package com.thiagosena.designpatternspringchallengedio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesignPatternSpringChallengeDioApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternSpringChallengeDioApplication.class, args);
    }

}