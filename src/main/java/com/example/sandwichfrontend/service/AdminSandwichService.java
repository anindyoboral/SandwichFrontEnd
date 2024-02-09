package com.example.sandwichfrontend.service;

import com.example.sandwichfrontend.model.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class AdminSandwichService implements SandService {


    private RestTemplate rt =  new RestTemplate();
    private String baseUri = "http://10.24.234.253:8080/sandwiches/api";

    @Override
    public List<Sandwich> listSandwich() {
        ResponseEntity<? extends Object> re = null;
        List<Sandwich> sandwich = null;
        re = rt.exchange(baseUri + "/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Sandwich>>() {
        });
        sandwich = (List<Sandwich>) re.getBody();

        return sandwich;
    }


    @Override
    public boolean addSandwich(Sandwich s) {
        return false;
    }

    @Override
    public boolean deleteSandwich(Sandwich s) {
        return false;
    }


}
