package com.example.ceresto.eat.service;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.DiningTable;
import com.example.ceresto.eat.model.Ingredient;
import com.example.ceresto.eat.repository.DiningTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiningTableService {
    
    @Autowired
    private DiningTableRepository diningTableRepository;

    public DiningTableService(DiningTableRepository diningTableRepository) {
        this.diningTableRepository = diningTableRepository;
    }

    public Optional<DiningTable> getByStatus(StatusEnum status) {
        return diningTableRepository.findByStatus(status);
    }


}
