package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository <Booking, Long> {
}
