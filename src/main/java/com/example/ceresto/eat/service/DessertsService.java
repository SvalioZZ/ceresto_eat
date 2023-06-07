package com.example.ceresto.eat.service;

import com.example.ceresto.eat.enumerati.RecordStatus;
import com.example.ceresto.eat.model.Desserts;
import com.example.ceresto.eat.repository.DessertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DessertsService {

    @Autowired
    private DessertsRepository dessertsRepository;

    public DessertsService(DessertsRepository dessertsRepository) {
        this.dessertsRepository = dessertsRepository;
    }

//    public void updateRecordStatus(Long id, Desserts dessert) {
//        Optional<Desserts> updatedDesserts = dessertsRepository.findById(dessert.getId());
//        if (updatedDesserts.isPresent()) {
//            if (dessert.getStatus().equals(RecordStatus.ACTIVE)) {
//                dessert.setStatus(RecordStatus.DELETED);
//            }
//            if (dessert.getStatus().equals(RecordStatus.DELETED)) {
//                dessert.setStatus(RecordStatus.ACTIVE);
//            }
//
//            dessertsRepository.saveAndFlush(updatedDesserts.get());
//
//        } else throw new NullPointerException();
//
//    }

}
