package com.example.ceresto.eat.service;

import com.example.ceresto.eat.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
