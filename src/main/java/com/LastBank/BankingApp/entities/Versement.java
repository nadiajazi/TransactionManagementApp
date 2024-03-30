package com.LastBank.BankingApp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@DiscriminatorValue("V")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Versement extends Operation{
}
