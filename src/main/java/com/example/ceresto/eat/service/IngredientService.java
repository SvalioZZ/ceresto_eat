package com.example.ceresto.eat.service;

import com.example.ceresto.eat.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    
    @Autowired
    private IngredientRepository ingredientRepository;
    
}
