package com.example.ceresto.eat.service;

import com.example.ceresto.eat.repository.CourseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailsService {
    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    public CourseDetailsService(CourseDetailsRepository courseDetailRepository) {
        this.courseDetailsRepository = courseDetailsRepository;
    }
}
