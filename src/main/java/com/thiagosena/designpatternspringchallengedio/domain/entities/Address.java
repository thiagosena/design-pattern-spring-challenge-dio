package com.thiagosena.designpatternspringchallengedio.domain.entities;

import com.thiagosena.designpatternspringchallengedio.infra.client.AddressModel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Address() {
    }

    public Address(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public static Address of(AddressModel model) {
        return new Address(
                model.cep(),
                model.uf(),
                model.bairro(),
                model.localidade(),
                model.complemento(),
                model.logradouro());
    }
}