package com.ripple.trustline.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ripple.trustline.domain.Party;
import com.ripple.trustline.domain.Transaction;
import com.ripple.trustline.domain.TrustLineStatusException;
import com.ripple.trustline.service.PartyService;
import com.ripple.trustline.service.TransactionService;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;

@RestController
public class PayMoneyController {

	Logger logger = LogManager.getLogger(PayMoneyController.class);

	
	@Autowired
	private PartyService partyService;

	@Autowired
	private TransactionService transictionService;

	@RequestMapping(value = "/payto/{party}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction payTo(@PathVariable(value = "party") String partyName,
			@RequestBody @Validated Transaction transaction) {

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
		//1-transfer money
		logger.info("Paying " + transaction.getAmount().toString() + " to " + transaction.getPayedTo().getName() + "...\n" );
		transferMoney(transaction);
		logger.info("Sent\n");
		//2-save transaction
		transaction = transictionService.createTransaction(transaction);
		//3-update balance 
		Party party = partyService.updateBalace(transaction.getPayedTo(),transaction.getAmount().negate());
		logger.info("Trustline balance is: " + party.getBalance().toString());
		//4- return response 
		return transaction;//"Paying 10 to Bob...\n" + "Sent\n" + "rustline balance is: -10";
	}
	
	//TODO: transaction time out handler and transaction reversal
	private Transaction transferMoney(Transaction transaction) {
		  
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<Transaction> entity = new HttpEntity<Transaction>(transaction,headers);
	      
	      return ( new RestTemplate() ).exchange(
	         transaction.getPayedTo().getUrl() + "/recieveFrom/Alice", HttpMethod.POST, entity, Transaction.class).getBody();
	 
		
	}
	

}
