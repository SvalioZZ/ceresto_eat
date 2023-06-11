package com.example.ceresto.eat.service;

import com.example.ceresto.eat.repository.DiningTableRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DiningTableService {
    
    @Autowired
    private DiningTableRepository diningTableRepository;
    
    public DiningTableService(DiningTableRepository diningTableRepository) {
        this.diningTableRepository = diningTableRepository;
    }
}
