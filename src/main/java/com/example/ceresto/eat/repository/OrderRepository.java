package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    void updateStatusById(StatusEnum status, Long id);
}
