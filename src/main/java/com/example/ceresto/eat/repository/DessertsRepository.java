package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.Desserts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertsRepository extends JpaRepository<Desserts, Long> {
}
