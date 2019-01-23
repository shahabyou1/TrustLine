package com.ripple.trustline.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ripple.trustline.domain.Party;
import com.ripple.trustline.domain.Transaction;
import com.ripple.trustline.domain.TrustLineStatusException;
import com.ripple.trustline.service.PartyService;
import com.ripple.trustline.service.TransactionService;

@RestController
public class RecieveMoneyController {

	Logger logger = LogManager.getLogger(RecieveMoneyController.class);
	@Autowired
	private PartyService partyService;

	@Autowired
	private TransactionService transictionService;

	@RequestMapping(value = "/recieveFrom/{party}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction reciveMoney(@PathVariable(value = "party") String partyName, @RequestBody @Validated Transaction transaction) {

		Party party = validateParty(partyName);
		if (party == null) {
			throw new ResponseStatusException(TrustLineStatusException.USER_EXIST.getHttpStatus(),
					TrustLineStatusException.USER_EXIST.getMessage()); 
		}

		transaction.setPayedTo(party);
		
		return process(transaction);		
	}

	private Party validateParty(String partyName) {
		return partyService.getPartyByName(partyName);
	}

	private Transaction process(Transaction transaction) {
		//save transaction
		logger.debug("You were paid " + transaction.getAmount().toString() + "!\n ");
		transaction = transictionService.createTransaction(transaction);
		
		//update balance 
		Party party = partyService.updateBalace(transaction.getPayedTo(), transaction.getAmount());
		logger.debug("Trustline balance is: " + party.getBalance().toEngineeringString() + "\n ");
		// return response 
		return transaction;
	}
}
