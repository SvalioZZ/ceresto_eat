package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.DettaglioPortata;
import com.example.ceresto.eat.repository.CourseDetailsRepository;
import com.example.ceresto.eat.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course-details")
public class CourseDetailsController {

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    @Autowired
    private CourseDetailsService courseDetailsService;

    @PostMapping("/create")
    public ResponseEntity<String> createCourseDetail (@RequestBody DettaglioPortata dettaglioPortata, @RequestParam String username) {
        dettaglioPortata.setCreatedBy(username);
        dettaglioPortata.setCreatedDate(LocalDateTime.now());
        dettaglioPortata.setLastModifiedBy(username);
        dettaglioPortata.setLastModifiedDate(LocalDateTime.now());
        courseDetailsRepository.saveAndFlush(dettaglioPortata);
        return ResponseEntity.ok("Course Details created successfully");
    }

    @GetMapping("/get-all")
    public List<DettaglioPortata> getAllCoursesDetails() {
        return courseDetailsRepository.findAll();
    }
    

    @GetMapping("/get-by-id/{id}")
    public Optional<DettaglioPortata> getById(@PathVariable("id") Long id) {
        return courseDetailsRepository.findById(id);
    }

    @GetMapping ("/get-active-records")
    public Optional<List<DettaglioPortata>> getActiveRecords(){
        return courseDetailsService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody DettaglioPortata dettaglioPortata, @RequestParam String username) {
        courseDetailsRepository.deleteById(id);
        dettaglioPortata.setLastModifiedBy(username);
        dettaglioPortata.setLastModifiedDate(LocalDateTime.now());
        courseDetailsRepository.save(dettaglioPortata);
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
        DettaglioPortata dettaglioPortataToSet = courseDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Course details not found"));
        if (dettaglioPortataToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            dettaglioPortataToSet.setStatus(StatusEnum.DELETED);
        } else dettaglioPortataToSet.setStatus(StatusEnum.ACTIVE);
        courseDetailsRepository.updateStatusById(dettaglioPortataToSet.getStatus(), id);

        return ResponseEntity.ok("Course detail with id " + id + "status changed to " + dettaglioPortataToSet.getStatus());
    }


}
