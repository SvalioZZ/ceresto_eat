package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.RecordStatus;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update Customer SET status = :status WHERE customer_id = :customer_id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") RecordStatus status, @Param(value = "customer_id") Long id);
    
    @Query(value = "SELECT * FROM customer WHERE name = :name", nativeQuery = true)
    Optional<Course> getFromName (@Param("name") String name);

}
