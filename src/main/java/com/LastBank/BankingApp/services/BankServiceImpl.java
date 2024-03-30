package com.LastBank.BankingApp.services;

import com.LastBank.BankingApp.dao.AccountRepository;
import com.LastBank.BankingApp.dao.OperationRepository;
import com.LastBank.BankingApp.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class BankServiceImpl implements BankService{

    @Autowired
    private OperationRepository operationRepository;
    private AccountRepository accountRepository;
    @Override
    public Account consulterCompte(String codeCpte) {
        Account account = accountRepository.findOne(codeCpte);
        if (account==null) throw new RuntimeException("Compte introuvable");

        return account;
    }

    @Override
    public void verser(String codeCpte, double montant) {
       Account account = consulterCompte(codeCpte);
       Versement v = new Versement(LocalDateTime.now(),montant,account);
       operationRepository.save(v);
       account.setBalance(account.getBalance()+montant);
       accountRepository.save(account);
    }

    @Override
    public void retirer(String codeCpte, double montant) {Account account = consulterCompte(codeCpte);
        double facilityCaisse=0;
        if (account instanceof CompteCourant)
            facilityCaisse=((CompteCourant) account).getDecouvert();
        if (account.getBalance()+facilityCaisse<montant)
            throw new RuntimeException("solde insuffisant");
        Retrait r = new Retrait(LocalDateTime.now(),montant,account);
        operationRepository.save(r);
        account.setBalance(account.getBalance()-montant);
        accountRepository.save(account);
    }

    @Override
    public void virement(String codeCpte1, String codeCpte2, double montant) {
       retirer(codeCpte1,montant);
       retirer(codeCpte2,montant );
    }

    @Override
    public Page<Operation> listOperation(String codeCpte, int page, int size) {
        return operationRepository.listOperation(codeCpte, PageRequest.of(page, size, Sort.unsorted()));
    }
}
