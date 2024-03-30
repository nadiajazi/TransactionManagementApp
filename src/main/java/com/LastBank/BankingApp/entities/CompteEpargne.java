package com.LastBank.BankingApp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CE")
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
public class CompteEpargne extends Account{
    private double taux;
}
