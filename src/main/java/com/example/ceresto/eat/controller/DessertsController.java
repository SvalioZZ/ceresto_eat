package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.Desserts;
import com.example.ceresto.eat.repository.DessertsRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/desserts")
public class DessertsController {
    @Autowired
    private DessertsRepository dessertsRepository;

    @PostMapping("/create")
    public void createDessert(@RequestBody Desserts dessert) {
        dessertsRepository.saveAndFlush(dessert);
    }

    @GetMapping("/getAll")
    public List<Desserts> getAllDesserts() {
        return dessertsRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Desserts> getById(@PathVariable Long id) {
        return dessertsRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String modifyHall(@PathVariable Long id, @RequestBody Desserts desserts){
        dessertsRepository.deleteById(id);
        dessertsRepository.save(desserts);
        return "Dessert updated";
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        dessertsRepository.deleteById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        dessertsRepository.deleteAll();
    }


}
