package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.RecordStatus;
import com.example.ceresto.eat.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update Ingredient SET status = :status WHERE ingredient_id = :ingredient_id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") RecordStatus recordStatus, @Param(value = "ingredient_id") Long id);


}
