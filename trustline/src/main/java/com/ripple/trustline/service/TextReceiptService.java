package com.ripple.trustline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripple.trustline.domain.Transaction;
import com.ripple.trustline.repository.PartyRepository;
import com.ripple.trustline.repository.TransactionRepository;

@Service
public class TextReceiptService {

	private TransactionRepository transactionRepository;
	private PartyRepository partyRepository;

	@Autowired
	public TextReceiptService(TransactionRepository transactionRepository, PartyRepository partyRepository) {
		super();
		this.transactionRepository = transactionRepository;
		this.partyRepository = partyRepository;
	}



	public void sendTextReceipt(Transaction transaction) {
		
	}
}
