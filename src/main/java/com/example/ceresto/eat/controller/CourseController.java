package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/create")
    public void createCourse(@RequestBody Course course) {
        courseRepository.saveAndFlush(course);
    }

    @GetMapping("/getAll")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Course> getById(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String modifyHall(@PathVariable Long id, @RequestBody Course course){
        courseRepository.deleteById(id);
        courseRepository.save(course);
        return "Course updated";
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        courseRepository.deleteAll();
    }
}
