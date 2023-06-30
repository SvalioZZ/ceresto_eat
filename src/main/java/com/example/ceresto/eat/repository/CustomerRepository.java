package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
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
    @Query(value = "update customer SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") StatusEnum status, @Param(value = "id") Long id);
    
    @Query(value = "SELECT * FROM customer WHERE name = :name", nativeQuery = true)
    Optional<Customer> getFromName (@Param("name") String name);


    Optional<List<Customer>> findByStatus(StatusEnum status);
}
