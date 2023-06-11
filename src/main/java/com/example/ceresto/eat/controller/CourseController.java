package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get-all")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    @GetMapping("/get-by-name/{name}")
    public List<Course> getByName(@PathVariable("name") String name) {
        return courseRepository.getFromName(name);
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Course> getById(@PathVariable("id") Long id) {
        return courseRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> modifyById(@PathVariable Long id, @RequestBody Course course){
        courseRepository.deleteById(id);
        courseRepository.save(course);
        return new ResponseEntity<>("Course with id " + id + ":\n" + course.getInfo(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        courseRepository.deleteAll();
    }
}
