package com.LastBank.BankingApp.dao;

import com.LastBank.BankingApp.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface operationRepository extends JpaRepository<Operation,Long> {
}
