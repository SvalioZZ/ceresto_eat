package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningTableRepository extends JpaRepository<DiningTable, Integer> {
}