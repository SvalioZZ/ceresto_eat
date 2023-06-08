package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.SecondCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondCoursesRepository extends JpaRepository <SecondCourses, Long> {
}
