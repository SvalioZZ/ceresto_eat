package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.model.Ingredient;
import com.example.ceresto.eat.repository.IngredientRepository;
import com.example.ceresto.eat.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientService ingredientService;

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

    @GetMapping("/get-by-type/{type}")
    public List<Ingredient> getByType(@PathVariable("type") String type){
        return ingredientRepository.getFromType(type);
    }

    @GetMapping ("/get-active-records")
    public Optional<Ingredient> getActiveRecords(){
        return ingredientService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Long id, @RequestBody Ingredient ingredient){
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

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        Ingredient ingredientToSet = ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        if (ingredientToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            ingredientToSet.setStatus(StatusEnum.DELETED);
        } else ingredientToSet.setStatus(StatusEnum.ACTIVE);
        ingredientRepository.updateStatusById(ingredientToSet.getStatus(), id);

        return ResponseEntity.ok("Ingredient with id " + id + "status changed to " + ingredientToSet.getStatus());
    }
    
    @GetMapping("/get-by-name/{name}")
    public List<Ingredient> getByName(@PathVariable("name") String name) {
        return ingredientRepository.getFromName(name);
    }
}
