package com.LastBank.BankingApp.services;


import com.LastBank.BankingApp.dao.ClientRepository;
import com.LastBank.BankingApp.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client getClientById(Integer id) {
        Optional <Client> optional = clientRepository.findById(id);
        Client client = null;
        if (optional.isPresent()){
            client=optional.get();
        }else {
            throw new RuntimeException("client not found with this id:: "+id);
        }

        return client;
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}
