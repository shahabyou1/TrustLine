package com.ripple.trustline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ripple.trustline.domain.OwnerProfile;

@RepositoryRestResource(exported = false)
public interface OwnerProfileRepository extends CrudRepository<OwnerProfile, String> {


}
