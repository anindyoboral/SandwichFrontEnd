package com.example.sandwichfrontend.controller;

import com.example.sandwichfrontend.model.Sandwich;
import com.example.sandwichfrontend.service.AdminSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class SandwichController {

    @Autowired
    AdminSandwichService adminService;

    Sandwich sandwich;

    @GetMapping("/sandwiches")
    public String showListOfSandwiches(Model model){
        List<Sandwich> sandwiches = adminService.listSandwich();
        model.addAttribute("sandwiches", sandwiches);
        return "sandwiches";
    }

}
