package com.ripple.trustline.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripple.trustline.domain.Party;
import com.ripple.trustline.domain.Transaction;
import com.ripple.trustline.repository.PartyRepository;
import com.ripple.trustline.repository.TransactionRepository;

/**
 * @author Shahab
 *
 */
@Service
public class TransactionService {

	private PartyRepository partyRepository;
	private TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionService(PartyRepository partyRepository, TransactionRepository transactionRepository) {
		super();
		this.partyRepository = partyRepository;
		this.transactionRepository = transactionRepository;
	}
	

    public Transaction createTransaction(Transaction transaction) {
    		return transactionRepository.save(transaction);
    }
	
}
