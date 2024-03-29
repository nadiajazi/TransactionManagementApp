package com.LastBank.BankingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long numOpertion;
   private Date dateOperation;
   private double montant;
   @ManyToOne
   @JoinColumn(name = "CODE_CPTE")
   private Account account;
}
