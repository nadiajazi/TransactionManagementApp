package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetraitRepository extends JpaRepository<Retrait,Long> {
}
