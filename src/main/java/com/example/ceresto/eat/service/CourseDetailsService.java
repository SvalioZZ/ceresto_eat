package com.example.ceresto.eat.service;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.CourseDetails;
import com.example.ceresto.eat.repository.CourseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDetailsService {
    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    public CourseDetailsService(CourseDetailsRepository courseDetailRepository) {
        this.courseDetailsRepository = courseDetailsRepository;
    }

    public Optional<List<CourseDetails>> getByType(CourseTypeEnum type){
        return courseDetailsRepository.getByType(type);
    }

    public Optional<List<CourseDetails>> getByStatus(StatusEnum status){
        return courseDetailsRepository.getByStatus(status);
    }
}
