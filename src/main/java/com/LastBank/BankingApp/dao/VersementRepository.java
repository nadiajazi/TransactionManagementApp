package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.Versement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersementRepository extends JpaRepository<Versement,Long> {
}
