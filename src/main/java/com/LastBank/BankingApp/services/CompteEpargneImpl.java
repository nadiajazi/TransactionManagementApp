package com.LastBank.BankingApp.services;


import com.LastBank.BankingApp.dao.CompteEpargneRepository;
import com.LastBank.BankingApp.entities.CompteEpargne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteEpargneImpl implements CompteEpargneService{

    @Autowired
    private CompteEpargneRepository compteEpargneRepository;
    @Override
    public void saveAccountCe(CompteEpargne compteEpargne) {
        this.compteEpargneRepository.save(compteEpargne);
    }
}
