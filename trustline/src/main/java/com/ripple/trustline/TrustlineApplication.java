package com.ripple.trustline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ripple.trustline.domain.Party;
import com.ripple.trustline.repository.PartyRepository;

@SpringBootApplication
public class TrustlineApplication implements CommandLineRunner{

	@Autowired
	private PartyRepository partyRepository;

	public static void main(String[] args) {
		SpringApplication.run(TrustlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		//partyRepository.save(new Party("Bob","Bob@gmail.com","1234567890","http://localhost:18081/trustline"));
		//partyRepository.save(new Party("Alice","Alice@gmail.com","9090909090","http://localhost:18080/trustline"));
	}
	
}

