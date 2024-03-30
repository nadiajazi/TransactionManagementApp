package com.LastBank.BankingApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    private String name;
    private String email;
    @OneToMany(mappedBy = "client",fetch=FetchType.LAZY)
    private Collection<Account> accounts;

    public Client(String name, String mail) {
    }
}
