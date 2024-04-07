package com.LastBank.BankingApp.controllers;

import com.LastBank.BankingApp.entities.Account;
import com.LastBank.BankingApp.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private BankService bankService;

    @GetMapping("/account")
    public ResponseEntity<Account> getAccountById(@RequestParam("id") Integer accountId) {
        Account account = bankService.consulterCompteById(accountId);

        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/accountByCode")
    public ResponseEntity<Account> getAccountByCode(@RequestParam("code") String codeCompte) {
        Account account = bankService.consulterCompteByCode(codeCompte);

        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
