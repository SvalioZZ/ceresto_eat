package com.example.ceresto.eat.service;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public Optional<List<Course>> getByStatus(StatusEnum status) {
        return courseRepository.findByStatus(status);
    }
    
    public Optional<List<Course>> getByType(CourseTypeEnum type) {
        return courseRepository.getByType(type);
    }
}
