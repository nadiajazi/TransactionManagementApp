package com.LastBank.BankingApp;


import com.LastBank.BankingApp.dao.ClientRepository;
import com.LastBank.BankingApp.dao.CompteCourantRepository;
import com.LastBank.BankingApp.dao.CompteEpargneRepository;
import com.LastBank.BankingApp.dao.RetraitRepository;
import com.LastBank.BankingApp.entities.Client;
import com.LastBank.BankingApp.entities.CompteCourant;
import com.LastBank.BankingApp.entities.CompteEpargne;
import com.LastBank.BankingApp.entities.Retrait;
import com.LastBank.BankingApp.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDateTime;


@SpringBootApplication
public class BankingAppApplication {


	public static void main(String[] args) {

		SpringApplication.run(BankingAppApplication.class, args);
	}
    @Bean
	public CommandLineRunner commandLineRunner (
			ClientRepository clientRepository,
			CompteCourantRepository compteCourantRepository,
			CompteEpargneRepository compteEpargneRepository,
			RetraitRepository retraitRepository,
			BankService bankService
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


		   var compteCourant = CompteCourant.builder()
				   .numCompte("124")
				   .holderAccountName("Amani")
				   .balance(500.0)
				   .client(client1)
				   .dateCreation(LocalDateTime.now())
				   .codeCompte("1105010")
				   .decouvert(200.0)
				   .build();
			compteCourantRepository.save(compteCourant);
			//CompteCourant compteCourant = new CompteCourant();
			//compteCourant.setNumCompte("CC123");
			//compteCourant.setHolderAccountName("Nadia");
			//compteCourant.setBalance(1000.0);
			//compteCourant.setClient(client);
			//compteCourant.setDateCreation(LocalDateTime.now());
			//compteCourant.setCodeCompte("123456");
			//compteCourant.setDecouvert(500.0);

			CompteEpargne compteEpargne = CompteEpargne.builder()
					.numCompte("124")
					.holderAccountName("Amani")
					.balance(500.0)
					.client(client1)
					.dateCreation(LocalDateTime.now())
					.codeCompte("110501")
					.taux(200.0)
					.build();
			compteEpargneRepository.save(compteEpargne);

			var retrait = Retrait.builder()
					.numOpertion(1L)
					.dateOperation(LocalDateTime.now())
					.montant(100.0)
					.account(compteEpargne)
					.build();
					retraitRepository.save(retrait);


            bankService.verser("110501",50.0);
		};

		}



}
