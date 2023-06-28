package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.CourseDetails;
import com.example.ceresto.eat.repository.CourseDetailsRepository;
import com.example.ceresto.eat.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courseDetails")
public class CourseDetailsController {

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    @Autowired
    private CourseDetailsService courseDetailsService;

    @PostMapping("/createDetails")
    public ResponseEntity<String> createCourseDetail (@RequestBody CourseDetails courseDetails, @RequestParam String username) {
        courseDetails.setCreatedBy(username);
        courseDetails.setCreatedDate(LocalDateTime.now());
        courseDetails.setLastModifiedBy(username);
        courseDetails.setLastModifiedDate(LocalDateTime.now());
        courseDetailsRepository.saveAndFlush(courseDetails);
        return ResponseEntity.ok("Course Details created successfully");
    }

    @GetMapping("/get-all")
    public List<CourseDetails> getAllCoursesDetails() {
        return courseDetailsRepository.findAll();
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<CourseDetails> getByName(@PathVariable("name") String name) {
        Optional<CourseDetails> courseDetails = courseDetailsRepository.getByName(name);
        return courseDetails.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<CourseDetails> getById(@PathVariable("id") Long id) {
        return courseDetailsRepository.findById(id);
    }

    @GetMapping("/get-by-type/{type}")
    public ResponseEntity<List<CourseDetails>> getByType(@PathVariable("type") CourseTypeEnum type){
        Optional<List<CourseDetails>> courseDetailsList = courseDetailsService.getByType(type);
        return courseDetailsList.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping ("/get-active-records")
    public Optional<List<CourseDetails>> getActiveRecords(){
        return courseDetailsService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody CourseDetails courseDetails, @RequestParam String username) {
        courseDetailsRepository.deleteById(id);
        courseDetails.setLastModifiedBy(username);
        courseDetails.setLastModifiedDate(LocalDateTime.now());
        courseDetailsRepository.save(courseDetails);
        return ResponseEntity.ok("Course Details with id " + id + " updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        courseDetailsRepository.deleteById(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        courseDetailsRepository.deleteAll();
    }

    @PatchMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatusById(@PathVariable Long id) {
        CourseDetails courseDetailsToSet = courseDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Course details not found"));
        if (courseDetailsToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            courseDetailsToSet.setStatus(StatusEnum.DELETED);
        } else courseDetailsToSet.setStatus(StatusEnum.ACTIVE);
        courseDetailsRepository.updateStatusById(courseDetailsToSet.getStatus(), id);

        return ResponseEntity.ok("Course detail with id " + id + "status changed to " + courseDetailsToSet.getStatus());
    }


}
