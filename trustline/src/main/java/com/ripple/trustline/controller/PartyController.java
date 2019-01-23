package com.ripple.trustline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ripple.trustline.domain.OwnerProfile;
import com.ripple.trustline.domain.Party;
import com.ripple.trustline.domain.TrustLineStatusException;
import com.ripple.trustline.service.OwnerProfileService;
import com.ripple.trustline.service.PartyService;

@RestController
public class PartyController {

	@Autowired
	private PartyService partyService;
	
	@RequestMapping(value = "party",  method = RequestMethod.POST, produces = "application/json") 
	@ResponseStatus(HttpStatus.CREATED)
	public Party createParty(@RequestBody @Validated Party party) {	
		return partyService.createParty(party) ;
	}
}
