package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
