package com.LastBank.BankingApp.services;

import com.LastBank.BankingApp.dao.CompteCourantRepository;
import com.LastBank.BankingApp.entities.CompteCourant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteCourantImpl implements CompteCourantService{

    @Autowired
    private CompteCourantRepository compteCourantRepository;

    @Override
    public void saveAccountCc(CompteCourant compteCourant) {
        this.compteCourantRepository.save(compteCourant);
    }
}
