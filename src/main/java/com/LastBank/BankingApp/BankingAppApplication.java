package com.LastBank.BankingApp;

import com.LastBank.BankingApp.dao.ClientRepository;
import com.LastBank.BankingApp.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner {

    private final ClientRepository clientRepository;
	@Autowired
	public BankingAppApplication(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(BankingAppApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
        Client c1=clientRepository.save(new Client("Nadia","jazinadia7@gmail.com"));
		Client c2=clientRepository.save(new Client("Amani","jaziamani@gmail.com"));
		Client c3=clientRepository.save(new Client("Amal","daknouamal@gmail.com"));
		Client c4=clientRepository.save(new Client("hichem","jazihichem@gmail.com"));

	}
}
