package com.example.ceresto.eat.service;

import com.example.ceresto.eat.repository.DiningTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiningTableService {
    
    @Autowired
    private DiningTableRepository diningTableRepository;
    
}
