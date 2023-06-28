package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Booking;
import com.example.ceresto.eat.model.Customer;
import com.example.ceresto.eat.model.DiningTable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository <Booking, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update course_details SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") StatusEnum Status, @Param(value = "id") Long id);
    Optional<Booking> getByCustomer(Customer customer_id);
    //Optional<List<Booking>> getByType(DiningTable type);
    Optional<List<Booking>> getByStatus(StatusEnum status);
}
