package com.thiagosena.designpatternspringchallengedio.infra.client;

public record AddressModel(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String gia,
        String ddd,
        String siafi
) {
}