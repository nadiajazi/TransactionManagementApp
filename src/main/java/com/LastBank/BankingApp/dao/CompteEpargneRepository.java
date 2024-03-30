package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteEpargneRepository extends JpaRepository<CompteEpargne,Long> {
}
