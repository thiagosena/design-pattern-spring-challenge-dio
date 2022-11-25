package com.thiagosena.designpatternspringchallengedio.domain.repository;

import com.thiagosena.designpatternspringchallengedio.domain.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}