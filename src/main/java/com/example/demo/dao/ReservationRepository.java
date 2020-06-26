package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
