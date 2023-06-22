package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//TODO dobbiamo prelevare solo gli oggetti che hanno active come recordStatus

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update course SET audit = :audit WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "audit") StatusEnum audit, @Param(value = "id") Long id);
    
    @Query(value = "SELECT * FROM course WHERE name = :name", nativeQuery = true)
    List<Course> getFromName (@Param("name") String name);

    @Query(value = "SELECT * FROM course WHERE type = :type", nativeQuery = true)
    List<Course> getFromType (@Param("type") String type);
    
    Optional<Course> getByName(String name);
    Optional<List<Course>> findByStatus(StatusEnum status);
}
