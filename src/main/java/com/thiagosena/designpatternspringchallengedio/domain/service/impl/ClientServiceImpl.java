package com.thiagosena.designpatternspringchallengedio.domain.service.impl;

import com.thiagosena.designpatternspringchallengedio.api.ResourceNotFoundException;
import com.thiagosena.designpatternspringchallengedio.domain.entities.Address;
import com.thiagosena.designpatternspringchallengedio.domain.entities.Client;
import com.thiagosena.designpatternspringchallengedio.domain.repository.AddressRepository;
import com.thiagosena.designpatternspringchallengedio.domain.repository.ClientRepository;
import com.thiagosena.designpatternspringchallengedio.domain.service.ClientService;
import com.thiagosena.designpatternspringchallengedio.infra.client.AddressModel;
import com.thiagosena.designpatternspringchallengedio.infra.client.ViaCepClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final ViaCepClient viaCepClient;

    public ClientServiceImpl(
            ClientRepository clientRepository,
            AddressRepository addressRepository,
            ViaCepClient viaCepClient) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.viaCepClient = viaCepClient;
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void insert(Client client) {
        saveOrUpdate(client);

    }

    @Override
    public void update(Long id, Client client) {
        boolean present = clientRepository.findById(id).isPresent();
        if (present) {
            client.setId(id);
            saveOrUpdate(client);
        } else {
            log.error("The client is not founded! {}", client);
            throw new ResourceNotFoundException("The client is not founded!");
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveOrUpdate(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            AddressModel addressModel = viaCepClient.getByCep(cep);
            Address newAddress = Address.of(addressModel);
            addressRepository.save(newAddress);
            return newAddress;
        });

        client.setAddress(address);
        clientRepository.save(client);
    }
}