package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.CourseDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Long > {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update course_details SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(@Param(value = "status") StatusEnum Status, @Param(value = "id") Long id);
    Optional<CourseDetails> getByName(String name);
    Optional<List<CourseDetails>> getByType(CourseTypeEnum type);
    Optional<List<CourseDetails>> getByStatus(StatusEnum status);

}
