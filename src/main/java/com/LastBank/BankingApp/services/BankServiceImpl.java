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
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankServiceImpl implements BankService{

    @Autowired
    private final OperationRepository operationRepository;
    private final AccountRepository accountRepository;
    @Autowired
    public BankServiceImpl(OperationRepository operationRepository, AccountRepository accountRepository) {
        this.operationRepository = operationRepository;
        this.accountRepository = accountRepository;
    }




    @Override
    public void verser(String codeCompte, double montant) {
       Account account = consulterCompteByCode(codeCompte);
       Versement v = new Versement(LocalDateTime.now(),montant,account);
       operationRepository.save(v);
       account.setBalance(account.getBalance()+montant);
       accountRepository.save(account);
    }

    @Override
    public void retirer(String codeCompte, double montant) {Account account = consulterCompteByCode(codeCompte);
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
    public void virement(String codeCompte1, String codeCompte2, double montant) {
       retirer(codeCompte1,montant);
       verser(codeCompte2,montant );
    }

    @Override
    public Page<Operation> listOperation(String codeCompte, int page, int size) {
        return operationRepository.listOperation(codeCompte, PageRequest.of(page, size, Sort.unsorted()));
    }

    @Override
    public Account consulterCompteById(Integer accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        return optionalAccount.orElse(null);
    }

    @Override
    public Account consulterCompteByCode(String codeCompte) {
        return accountRepository.findOneByCodeCompte(codeCompte);

    }
    @Override
    public List<Account> getAllAccounts(){
     return accountRepository.findAll() ;
    }

    @Override
    public void saveAccount (Account account){
        this.accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Integer id){
        Optional <Account> optional = accountRepository.findById(id);
        Account account = null;
        if (optional.isPresent()) {
            account = optional.get();
        }else{
          throw new RuntimeException("account not found with id:: " +id);
        }
        return account;
    }

    @Override
    public void deleteAccountById(Integer id) {
        this.accountRepository.deleteById(id);
    }
}
