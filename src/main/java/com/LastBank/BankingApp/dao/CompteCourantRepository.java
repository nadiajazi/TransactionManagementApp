package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteCourantRepository extends JpaRepository<CompteCourant,Long> {
}
