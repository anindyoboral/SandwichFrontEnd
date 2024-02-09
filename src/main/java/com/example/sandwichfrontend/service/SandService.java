package com.example.sandwichfrontend.service;

import com.example.sandwichfrontend.model.Sandwich;

import java.util.List;

public interface SandService {

    boolean addSandwich (Sandwich s);
    boolean deleteSandwich (Sandwich s);
    List<Sandwich> listSandwich ();
}
