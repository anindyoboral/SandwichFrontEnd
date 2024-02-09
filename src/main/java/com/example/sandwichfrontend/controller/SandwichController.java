package com.example.sandwichfrontend.controller;

import com.example.sandwichfrontend.model.Sandwich;
import com.example.sandwichfrontend.service.AdminSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class SandwichController {

    @Autowired
    AdminSandwichService adminService;

    Sandwich newSandwich;

    @GetMapping("/sandwiches")
    public String showListOfSandwiches(Model model){
        List<Sandwich> sandwiches = adminService.listSandwich();
        model.addAttribute("sandwiches", sandwiches);
        return "sandwiches";
    }

    @GetMapping("/addsandwich")
    public String sandwichForm(Model model) {
        model.addAttribute("sandwich", new Sandwich());
        System.out.println("in get form for add sandwich");
        return "addsandwich";
    }

    @PostMapping("/addsandwich")
    public String addnewsandwich(Model model, @ModelAttribute("sandwich") Sandwich sandwich){
        System.out.println("sandwich name"+ sandwich.getName());
       boolean newSandwichResult = adminService.addSandwich(sandwich);
        model.addAttribute("addsandwich", newSandwichResult);

        if(newSandwichResult){
            return "redirect:/sandwiches";
        }
        return "addsandwich";
    }


    @GetMapping("/deletesandwich")
    public String sandwichdeleteForm(Model model) {
        model.addAttribute("sandwich", new Sandwich());
        System.out.println("in delete sandwich");
        return "deletesandwich";
    }

    @PostMapping("/deletesandwich")
    public String deletesandwich(Model model, @ModelAttribute("sandwich") Sandwich sandwich){
        adminService.deleteSandwich(sandwich);
        return "redirect:/sandwiches";
    }

    @GetMapping("/updatesandwichprice")
    public String updatepricesandwichForm(Model model) {
        model.addAttribute("sandwich", new Sandwich());
        return "updatesandwichprice";
    }

    @PostMapping("/updatesandwichprice")
    public String updatePriceOfandwich(Model model, @ModelAttribute("sandwich") Sandwich sandwich){
        adminService.updateSandwichPrice(sandwich);
        return "redirect:/sandwiches";
    }

}
