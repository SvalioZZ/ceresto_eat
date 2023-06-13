package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.Customer;
import com.example.ceresto.eat.model.Ingredient;
import com.example.ceresto.eat.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping("/create")
    public void create(@RequestBody Ingredient ingredient) {
        ingredientRepository.saveAndFlush(ingredient);
    }

    @GetMapping("/get-all")
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Ingredient> getById(@PathVariable Long id) {
        return ingredientRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Ingredient ingredient){
        ingredientRepository.deleteById(id);
        ingredientRepository.save(ingredient);
        return "Ingredient updated";
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        ingredientRepository.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        ingredientRepository.deleteAll();
    }
}
