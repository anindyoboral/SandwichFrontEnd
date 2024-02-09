package com.example.sandwichfrontend.service;

import com.example.sandwichfrontend.model.Sandwich;

import java.util.List;

public interface SandService {

    boolean addSandwich (Sandwich s);
    void deleteSandwich (Sandwich s);

    void updateSandwichPrice (Sandwich s);
    List<Sandwich> listSandwich ();
}
