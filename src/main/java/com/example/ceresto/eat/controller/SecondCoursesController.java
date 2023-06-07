package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.Desserts;
import com.example.ceresto.eat.model.SecondCourses;
import com.example.ceresto.eat.repository.DessertsRepository;
import com.example.ceresto.eat.repository.SecondCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secondcourses")

public class SecondCoursesController {

    @Autowired
    private SecondCoursesRepository secondCoursesRepository;

    @PostMapping("/create")
    public void createSecond(@RequestBody SecondCourses secondCourses) {
        secondCoursesRepository.saveAndFlush(secondCourses);
    }

    @GetMapping("/getAll")
    public List<SecondCourses> getAllSeconds() {
        return secondCoursesRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<SecondCourses> getById(@PathVariable Long id) {
        return secondCoursesRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String modifyHall(@PathVariable Long id, @RequestBody SecondCourses secondCourses){
        secondCoursesRepository.deleteById(id);
        secondCoursesRepository.save(secondCourses);
        return "Second course updated";
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        secondCoursesRepository.deleteById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        secondCoursesRepository.deleteAll();
    }


}
