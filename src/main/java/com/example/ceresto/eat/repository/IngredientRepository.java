package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.AuditEnum;
import com.example.ceresto.eat.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update ingredient SET audit = :audit WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "audit") AuditEnum audit, @Param(value = "id") Long id);
    
    @Query(value = "SELECT * FROM ingredient WHERE name = :name", nativeQuery = true)
    List<Ingredient> getFromName (@Param("name") String name);

    @Query(value = "SELECT * FROM ingredient WHERE type = :type", nativeQuery = true)
    List<Ingredient> getFromType(String type);
}
