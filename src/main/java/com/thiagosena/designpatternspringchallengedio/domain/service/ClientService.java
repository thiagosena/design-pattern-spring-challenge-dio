package com.thiagosena.designpatternspringchallengedio.domain.service;

import com.thiagosena.designpatternspringchallengedio.domain.entities.Client;

public interface ClientService {
    Iterable<Client> findAll();

    Client findById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}