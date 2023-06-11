package com.example.ceresto.eat.service;

import com.example.ceresto.eat.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientService {
    
    @Autowired
    private IngredientRepository ingredientRepository;
    
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
}
