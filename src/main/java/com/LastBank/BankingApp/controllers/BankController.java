package com.LastBank.BankingApp.controllers;

import com.LastBank.BankingApp.dao.AccountRepository;
import com.LastBank.BankingApp.entities.Account;
import com.LastBank.BankingApp.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BankController {

    @Autowired
    private BankService bankService;


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listAccounts",bankService.getAllAccounts());
        return "Index";

    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model){
        Account account= new Account();
        model.addAttribute("account",account);
        return "new_account";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account) {
        bankService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {

        Account account = bankService.getAccountById(id);

        model.addAttribute("account", account);
        return "update_account";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {


        this.bankService.deleteAccountById(id);
        return "redirect:/";
    }
}
