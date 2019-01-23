package com.ripple.trustline.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ripple.trustline.domain.Transaction;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction,Integer> {

	@Override
	@RestResource(exported = false)
	void delete(Transaction arg0);

	@Override
	@RestResource(exported = false)
	void deleteAll();

	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends Transaction> arg0) ;

	@Override
	@RestResource(exported = false)
	void deleteById(Integer arg0);


	@Override
	@RestResource(exported = false)
	<S extends Transaction> S save(S arg0) ;

	@Override
	@RestResource(exported = false)
	<S extends Transaction> Iterable<S> saveAll(Iterable<S> arg0) ;

	
}
