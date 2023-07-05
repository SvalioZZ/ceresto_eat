package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.model.CourseDetail;
import com.example.ceresto.eat.model.Ingredient;
import com.example.ceresto.eat.repository.CourseDetailsRepository;
import com.example.ceresto.eat.repository.CourseRepository;
import com.example.ceresto.eat.repository.IngredientRepository;
import com.example.ceresto.eat.service.CourseDetailsService;
import com.example.ceresto.eat.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course-detail")
public class CourseDetailsController {

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    @Autowired
    private CourseDetailsService courseDetailsService;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createCourseDetail (@RequestBody CourseDetail courseDetail, @RequestParam String username) {
        courseDetail.setCreatedBy(username);
        courseDetail.setCreatedDate(LocalDateTime.now());
        courseDetail.setLastModifiedBy(username);
        courseDetail.setLastModifiedDate(LocalDateTime.now());
        courseDetailsRepository.saveAndFlush(courseDetail);
        return ResponseEntity.ok("Course Detail created successfully");
    }

    @GetMapping("/get-all")
    public List<CourseDetail> getAllCoursesDetails() {
        return courseDetailsRepository.findAll();
    }
    

    @GetMapping("/get-by-id/{id}")
    public Optional<CourseDetail> getById(@PathVariable("id") Long id) {
        return courseDetailsRepository.findById(id);
    }

    @GetMapping ("/get-active-records")
    public Optional<List<CourseDetail>> getActiveRecords(){
        return courseDetailsService.getByStatus(StatusEnum.ACTIVE);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody CourseDetail courseDetail, @RequestParam String username) {
        courseDetail.setCreatedBy(courseDetailsRepository.getReferenceById(id).getCreatedBy());
        courseDetail.setCreatedDate(courseDetailsRepository.getReferenceById(id).getCreatedDate());
        courseDetail.setLastModifiedBy(username);
        courseDetail.setLastModifiedDate(LocalDateTime.now());
        courseDetailsRepository.save(courseDetail);
        courseDetailsRepository.deleteById(id);
        return ResponseEntity.ok("Course Detail with id " + id + " updated successfully");
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
        CourseDetail courseDetailToSet = courseDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Course details not found"));
        if (courseDetailToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            courseDetailToSet.setStatus(StatusEnum.DELETED);
        } else courseDetailToSet.setStatus(StatusEnum.ACTIVE);
        courseDetailsRepository.updateStatusById(courseDetailToSet.getStatus(), id);

        return ResponseEntity.ok("Course detail with id " + id + "status changed to " + courseDetailToSet.getStatus());
    }


}
