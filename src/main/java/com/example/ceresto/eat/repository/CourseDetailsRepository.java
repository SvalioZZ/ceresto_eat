package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.CourseDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetail, Long > {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update course_detail SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") StatusEnum Status, @Param(value = "id") Long id);
    
    Optional<List<CourseDetail>> getByStatus(StatusEnum status);
    
}

