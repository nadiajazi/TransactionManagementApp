package com.LastBank.BankingApp.controllers;

import com.LastBank.BankingApp.entities.Account;
import com.LastBank.BankingApp.services.BankService;
import com.LastBank.BankingApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BankController {

    @Autowired
    private BankService bankService;
    private final ClientService clientService;

    public BankController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listAccounts",bankService.getAllAccounts());
        return "Index";

    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model){
        Account account= new Account();
        model.addAttribute("account",account);
        model.addAttribute("clients", clientService.findAllClients());

        return "new_account";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account, @RequestParam("accountType") String accountType) {
        bankService.saveAccount(account, accountType);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Integer id, Model model) {

        Account account = bankService.getAccountById(id);

        model.addAttribute("account", account);
        return "update_account";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable("id") Integer id) {


        this.bankService.deleteAccountById(id);
        return "redirect:/";
    }
}
