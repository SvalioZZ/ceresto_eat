package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update order SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") StatusEnum status, @Param(value = "id") Long id);
    
    Optional<Orders> findByStatus(StatusEnum status);
}
