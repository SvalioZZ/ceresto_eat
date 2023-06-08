package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.Beverage;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.repository.BeverageRepository;
import com.example.ceresto.eat.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beverages/")
public class BeverageController {
    @Autowired
    private BeverageRepository beverageRepository;
    @PostMapping("create")
    public void createBeverage(@RequestBody Beverage beverage) {
        beverageRepository.saveAndFlush(beverage);
    }
    
    @GetMapping("getAll")
    public List<Beverage> getAllBeverages() {
        return beverageRepository.findAll();
    }
    
    @GetMapping("get/{id}")
    public Optional<Beverage> getById(@PathVariable Long id) {
        return beverageRepository.findById(id);
    }
    
    @PutMapping("update/{id}")
    public String modifyHall(@PathVariable Long id, @RequestBody Beverage beverage){
        beverageRepository.deleteById(id);
        beverageRepository.save(beverage);
        return "Course updated";
    }
    
    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        beverageRepository.deleteById(id);
    }
    
    @DeleteMapping("deleteAll")
    public void deleteAll() {
        beverageRepository.deleteAll();
    }
}
