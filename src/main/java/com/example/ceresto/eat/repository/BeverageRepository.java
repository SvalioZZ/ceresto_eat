package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long> {



}
