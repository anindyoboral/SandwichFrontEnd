package com.example.sandwichfrontend.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class FeRestTemplate {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
