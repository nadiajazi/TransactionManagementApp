package com.LastBank.BankingApp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Entity
@DiscriminatorValue("R")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Retrait extends Operation{

}
