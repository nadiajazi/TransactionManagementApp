package com.LastBank.BankingApp;

import com.LastBank.BankingApp.dao.ClientRepository;
import com.LastBank.BankingApp.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingAppApplication {


	public static void main(String[] args) {

		SpringApplication.run(BankingAppApplication.class, args);
	}
    @Bean
	public CommandLineRunner commandLineRunner (
			ClientRepository clientRepository
	){
		return args -> {
           var client = Client.builder()
				   .name("nadia")
				   .email("jazinadia7@gmail.com")
				   .build();
		      clientRepository.save(client);

		   var client1 = Client.builder()
				   .name("amal")
				   .email("amaldaknou@gmail.com")
				   .build();
		   clientRepository.save(client1);
		};
	}



}
