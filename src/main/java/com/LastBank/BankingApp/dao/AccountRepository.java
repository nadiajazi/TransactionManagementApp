package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.Account;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {


    Optional<Account> findById(Long id);
    Account findOneByCodeCompte(String codeCompte);

}
