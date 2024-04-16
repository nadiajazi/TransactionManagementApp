package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {


}
