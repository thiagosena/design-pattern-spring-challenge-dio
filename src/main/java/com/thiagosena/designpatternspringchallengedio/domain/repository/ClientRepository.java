package com.thiagosena.designpatternspringchallengedio.domain.repository;

import com.thiagosena.designpatternspringchallengedio.domain.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}