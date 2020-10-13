package com.example.GeorgeItexico.commandlinerunner;

import com.example.GeorgeItexico.dao.IReservationRepository;
import com.example.GeorgeItexico.entity.Reservations;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

  @Autowired
  private IReservationRepository reservationsRepository;

  @Override
  public void run(String... args) throws Exception {
    //First we needs to ensure the db is clean
    reservationsRepository.deleteAll();

    //Here we are adding sample data to the H2 db.
    reservationsRepository.save(new Reservations("Jorge",      LocalDate.now()));
    reservationsRepository.save(new Reservations("Luis",      LocalDate.now().plusDays(1)));
    reservationsRepository.save(new Reservations("Alexander", LocalDate.now().plusDays(2)));
    reservationsRepository.save(new Reservations("Maria",     LocalDate.now().plusDays(3)));
    reservationsRepository.save(new Reservations("Carmen",    LocalDate.now().plusDays(4)));
    reservationsRepository.save(new Reservations("Janeth",    LocalDate.now().plusDays(5)));
    reservationsRepository.save(new Reservations("Bertha",    LocalDate.now().plusDays(6)));
    reservationsRepository.save(new Reservations("Guadalupe", LocalDate.now().plusDays(7)));

  }
}
