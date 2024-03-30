package com.LastBank.BankingApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @RequestMapping("/operations")
    public String index() {
        return "compte";
    }

}
