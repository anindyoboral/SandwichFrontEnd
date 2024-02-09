package com.example.sandwichfrontend.service;

import com.example.sandwichfrontend.model.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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

        ResponseEntity <? extends Object> re =null;
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Sandwich> requestEntity = new HttpEntity<>(s,requestHeaders);
        re =  rt.postForEntity(baseUri + "/sandwich/add",requestEntity,Object.class);
        if (re.getStatusCode().is2xxSuccessful()){
            return true;
        }
        return false;
    }

    @Override
    public void deleteSandwich(Sandwich s) {

        rt.delete(baseUri+"/sandwich/delete/"+ s.getId());
    }

    @Override
    public void updateSandwichPrice(Sandwich s) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Sandwich> requestEntity = new HttpEntity<>(s,requestHeaders);
        rt.postForEntity(baseUri + "/sandwich/updateprice",requestEntity,Object.class);
    }


}
