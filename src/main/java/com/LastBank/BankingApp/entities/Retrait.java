package com.LastBank.BankingApp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@NoArgsConstructor
@Entity
@DiscriminatorValue("R")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Retrait extends Operation{

    public Retrait(LocalDateTime now, double montant, Account account) {
    }
}
