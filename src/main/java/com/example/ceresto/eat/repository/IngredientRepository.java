package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update ingredient SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") StatusEnum status, @Param(value = "id") Long id);
    
    @Query(value = "SELECT * FROM ingredient WHERE name = :name", nativeQuery = true)
    List<Ingredient> getFromName (@Param("name") String name);

    @Query(value = "SELECT * FROM ingredient WHERE type = :type", nativeQuery = true)
    List<Ingredient> getFromType(@Param("type") String type);

    Optional<Ingredient> findByStatus(StatusEnum status);
}
