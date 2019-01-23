package com.ripple.trustline.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Optional;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ripple.trustline.domain.OwnerProfile;
import com.ripple.trustline.domain.Party;
import com.ripple.trustline.domain.TrustLineStatusException;
import com.ripple.trustline.repository.OwnerProfileRepository;
import com.ripple.trustline.repository.PartyRepository;

/**
 * @author Shahab
 *
 */
@Service
public class PartyService {

	private PartyRepository partyRepository;
	private OwnerProfileRepository ownerProfileRepository;

	@Autowired
	public PartyService(PartyRepository partyRepository, OwnerProfileRepository ownerProfileRepository) {
		super();
		this.ownerProfileRepository = ownerProfileRepository;
		this.partyRepository = partyRepository;
	}

	public Party createParty(Party party) {
		Iterator<OwnerProfile> ownerItrator =  ownerProfileRepository.findAll().iterator();
		if(!ownerItrator.hasNext()) {
			throw new ResponseStatusException(TrustLineStatusException.TL_USER_NOT_EXIST.getHttpStatus(),
					TrustLineStatusException.TL_USER_NOT_EXIST.getMessage());			
		}
		if (partyRepository.existsByName(party.getName()) || ownerItrator.next().getUrl().equals(party.getUrl())) {
			throw new ResponseStatusException(TrustLineStatusException.USER_EXIST.getHttpStatus(),
					TrustLineStatusException.USER_EXIST.getMessage());
		}

		return partyRepository.save(party);
	}
	
	public Party updateBalace(Party party, BigDecimal amount) {
		party.setBalance(party.getBalance().add(amount));
		return partyRepository.save(party);
	}

	public Iterable<Party> lookup() {
		return partyRepository.findAll();
	}

	public long total() {
		return partyRepository.count();
	}

	public Party getPartyByName(String partyName) {

		if (!partyRepository.existsByName(partyName))
			throw new ResponseStatusException(TrustLineStatusException.USER_EXIST.getHttpStatus(),
					TrustLineStatusException.USER_EXIST.getMessage());

		return partyRepository.findByName(partyName).get();
	}

}
