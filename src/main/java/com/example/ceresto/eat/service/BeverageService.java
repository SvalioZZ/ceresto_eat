package com.example.ceresto.eat.service;

import com.example.ceresto.eat.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeverageService {
    
    @Autowired
    private BeverageRepository beverageRepository;
    
    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }
}
