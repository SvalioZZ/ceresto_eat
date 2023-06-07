package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
