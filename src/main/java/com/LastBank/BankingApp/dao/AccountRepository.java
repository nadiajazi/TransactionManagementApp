package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<Account,Long> {
}
