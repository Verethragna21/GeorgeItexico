package com.example.GeorgeItexico.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Reservations {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;
  private LocalDate reservationDate;

  public Reservations(String name, LocalDate reservationDate) {
    this.name = name;
    this.reservationDate = reservationDate;
  }

}
