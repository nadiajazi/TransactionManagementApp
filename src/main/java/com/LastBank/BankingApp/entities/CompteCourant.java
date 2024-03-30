package com.LastBank.BankingApp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CC")
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
public class CompteCourant extends Account {
private double decouvert;


}
