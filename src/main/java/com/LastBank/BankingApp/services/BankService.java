package com.LastBank.BankingApp.services;

import com.LastBank.BankingApp.entities.Account;
import com.LastBank.BankingApp.entities.Operation;
import org.springframework.data.domain.Page;


public interface BankService {
    public Account consulterCompte(String codeCpte);
    public void verser (String codeCpte, double montant);
    public void retirer (String codeCpte, double montant);
    public void virement (String codeCpte1, String codeCpte2, double montant);
    public Page<Operation> listOperation(String codeCpte, int page, int size);
}
