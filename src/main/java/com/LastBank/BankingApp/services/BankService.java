package com.LastBank.BankingApp.services;

import com.LastBank.BankingApp.entities.Account;
import com.LastBank.BankingApp.entities.Operation;
import org.springframework.data.domain.Page;

import java.util.List;


public interface BankService {

    public void verser (String codeCpte, double montant);
    public void retirer (String codeCpte, double montant);
    public void virement (String codeCpte1, String codeCpte2, double montant);
    Account consulterCompteById(Integer accountId);

    Account consulterCompteByCode(String codeCompte);
    public Page<Operation> listOperation(String codeCpte, int page, int size);
    List<Account> getAllAccounts();

    void saveAccount(Account account);

    Account getAccountById(Integer id);

    void deleteAccountById(Integer id);
}
