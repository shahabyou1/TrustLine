package com.ripple.trustline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.*;
import com.ripple.trustline.domain.OwnerProfile;
import com.ripple.trustline.domain.TrustLineStatusException;
import com.ripple.trustline.service.OwnerProfileService;

@RestController
public class SignupController {

	@Autowired
	private OwnerProfileService ownerProfileService;
	
	@RequestMapping(value = "signup",  method = RequestMethod.POST, produces = "application/json") 
	@ResponseStatus(HttpStatus.CREATED)
	public OwnerProfile signup(@RequestBody @Validated OwnerProfile ownerProfile) {
		
		ownerProfile = ownerProfileService.signUp(ownerProfile);
		if(ownerProfile==null)
			throw new ResponseStatusException(TrustLineStatusException.USER_EXIST.getHttpStatus(), 
					TrustLineStatusException.USER_EXIST.getMessage());
		
		return ownerProfile ;
	}
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(IllegalArgumentException.class)
//    public String return400(IllegalArgumentException ex) {
//        return  ex.getMessage();
//
//    }
	
}
