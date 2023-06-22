package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.repository.CourseRepository;
import com.example.ceresto.eat.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public void createCourse(@RequestBody Course course) {
        courseRepository.saveAndFlush(course);
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
    public ResponseEntity<List<Course>> getByType(@PathVariable("type") String type){
        return new ResponseEntity<>(courseRepository.getFromType(type), HttpStatus.OK);
    }

    @GetMapping ("/get-active-records")
    public Optional<List<Course>> getActiveRecords(){
        return courseService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Course course) {
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
