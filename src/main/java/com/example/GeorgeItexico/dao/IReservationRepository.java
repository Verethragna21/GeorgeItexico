package com.example.GeorgeItexico.dao;

import com.example.GeorgeItexico.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation, Integer> {

}
