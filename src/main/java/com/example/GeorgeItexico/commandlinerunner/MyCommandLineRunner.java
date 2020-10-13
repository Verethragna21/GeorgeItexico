package com.example.GeorgeItexico.commandlinerunner;

import com.example.GeorgeItexico.dao.IReservationRepository;
import com.example.GeorgeItexico.entity.Reservation;
import java.time.LocalDateTime;
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
    reservationsRepository.save(new Reservation("Reservation No. 1", LocalDateTime.now()));
    reservationsRepository.save(new Reservation("Reservation No. 2", LocalDateTime.now().plusDays(1)));
    reservationsRepository.save(new Reservation("Reservation No. 3", LocalDateTime.now().plusDays(2)));
    reservationsRepository.save(new Reservation("Reservation No. 4", LocalDateTime.now().plusDays(3)));
    reservationsRepository.save(new Reservation("Reservation No. 5", LocalDateTime.now().plusDays(4)));
    reservationsRepository.save(new Reservation("Reservation No. 6", LocalDateTime.now().plusDays(5)));
    reservationsRepository.save(new Reservation("Reservation No. 7", LocalDateTime.now().plusDays(6)));
    reservationsRepository.save(new Reservation("Reservation No. 8", LocalDateTime.now().plusDays(7)));

  }
}
