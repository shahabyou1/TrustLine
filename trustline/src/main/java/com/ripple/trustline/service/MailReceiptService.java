package com.ripple.trustline.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripple.trustline.domain.Transaction;
import com.ripple.trustline.repository.PartyRepository;
import com.ripple.trustline.repository.TransactionRepository;

@Service
public class MailReceiptService {
	 
	private TransactionRepository transactionRepository;
	private PartyRepository partyRepository;

	@Autowired
	public MailReceiptService(TransactionRepository transactionRepository, PartyRepository partyRepository) {
		super();
		this.transactionRepository = transactionRepository;
		this.partyRepository = partyRepository;
	}


	public void sendMailReceipt(Transaction transaction) {
	}
}
