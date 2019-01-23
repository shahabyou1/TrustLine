package com.ripple.trustline.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ripple.trustline.domain.Party;

public interface PartyRepository extends CrudRepository<Party, Integer> {
	
	/**
	 * @param name
	 * @return
	 */
	Optional<Party> findByName(@Param("name") String name);
	/**
	 * @param email
	 * @return
	 */
	Optional<Party> findByEmail(@Param("email") String email);
	/**
	 * @param phone
	 * @return
	 */
	Optional<Party> findByPhone(@Param("phone") String phone);
	
	/**
	 * @param name
	 * @return
	 */
	boolean existsByName(@Param("name") String name);
	
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Party entity);
	
	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends Party> entities) ;
	
	@Override
	@RestResource(exported = false)
	void deleteAll() ;
	
	
	@Override
	@RestResource( exported = false)
	 <S extends Party> S save(S entity);
	@Override
	@RestResource(exported = false)
	<S extends Party> Iterable<S> saveAll(Iterable<S> entities) ;
	
	
}
