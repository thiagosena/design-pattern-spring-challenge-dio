package com.thiagosena.designpatternspringchallengedio.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "${client.viacep.url}")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    AddressModel getByCep(@PathVariable String cep);
}