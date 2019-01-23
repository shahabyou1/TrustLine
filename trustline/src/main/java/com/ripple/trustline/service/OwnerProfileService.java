package com.ripple.trustline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripple.trustline.domain.OwnerProfile;
import com.ripple.trustline.repository.OwnerProfileRepository;

@Service
public class OwnerProfileService {

	
	private OwnerProfileRepository ownerProfileRepository;

	@Autowired
	public OwnerProfileService(OwnerProfileRepository ownerProfileRepository) {
		super();
		this.ownerProfileRepository = ownerProfileRepository;
	}
	
	public OwnerProfile signUp(OwnerProfile ownerProfile) {	
		
		return ownerProfileRepository.count()==0 ? ownerProfileRepository.save(ownerProfile) : null;
	}
	
	
}
