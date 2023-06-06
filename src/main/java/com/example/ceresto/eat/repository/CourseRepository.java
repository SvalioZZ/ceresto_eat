package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
