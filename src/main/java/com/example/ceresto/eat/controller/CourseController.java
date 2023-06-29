package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.repository.CourseRepository;
import com.example.ceresto.eat.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;
    
    public CourseController(CourseRepository courseRepository, CourseService courseService) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> createCourse(@RequestBody Course course, @RequestParam String username) {
        course.setCreatedBy(username);
        course.setCreatedDate(LocalDateTime.now());
        course.setLastModifiedBy(username);
        course.setLastModifiedDate(LocalDateTime.now());
        courseRepository.saveAndFlush(course);
        return ResponseEntity.ok("Course created successfully");
    }

    @GetMapping("/get-all")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<Course> getByName(@PathVariable("name") String name) {
        Optional<Course> course = courseRepository.getByName(name);
        return course.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Course> getById(@PathVariable("id") Long id) {
        return courseRepository.findById(id);
    }

    @GetMapping("/get-by-type/{type}")
    public ResponseEntity<List<Course>> getByType(@PathVariable("type") CourseTypeEnum type){
        Optional<List<Course>> courseList = courseService.getByType(type);
        return courseList.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping ("/get-active-records")
    public Optional<List<Course>> getActiveRecords(){
        return courseService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Course course, @RequestParam String username) {
        courseRepository.deleteById(id);
        course.setLastModifiedBy(username);
        course.setLastModifiedDate(LocalDateTime.now());
        courseRepository.save(course);
        return ResponseEntity.ok("Course with id " + id + " updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        courseRepository.deleteAll();
    }

    @PatchMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatusById(@PathVariable Long id) {
        Course courseToSet = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        if (courseToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            courseToSet.setStatus(StatusEnum.DELETED);
        } else courseToSet.setStatus(StatusEnum.ACTIVE);
        courseRepository.updateStatusById(courseToSet.getStatus(), id);

        return ResponseEntity.ok("Course with id " + id + "status changed to " + courseToSet.getStatus());
    }




}
