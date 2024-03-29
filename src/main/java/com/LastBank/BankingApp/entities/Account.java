package com.LastBank.BankingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "accounts")
@DiscriminatorColumn(name = "TYPE_CPTE",discriminatorType = DiscriminatorType.STRING, length=2)
public abstract class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numCompte;
    private String HolderAccountName;
    private double Balance;
    private Date dateCreation;
    private String codeCompte;
    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    private Client client;
    @OneToMany(mappedBy = "account" )
    private Collection<Operation> operations;

}
