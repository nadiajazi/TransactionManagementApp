package com.LastBank.BankingApp.services;

import com.LastBank.BankingApp.entities.Client;

import java.lang.ref.Cleaner;
import java.util.List;

public interface ClientService {
    Client getClientById(Integer id);
    List<Client> findAllClients();
}
