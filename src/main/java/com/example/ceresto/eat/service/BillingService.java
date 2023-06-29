package com.example.ceresto.eat.service;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Billing;
import com.example.ceresto.eat.repository.BillingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingService {
    
    @Autowired
    private BillingRepo billingRepo;
    
    public BillingService(BillingRepo billingRepo) {
        this.billingRepo = billingRepo;
    }
    
    public Optional<Billing> getOrderById(StatusEnum status) {
        return billingRepo.findByStatus(status);
    }
}
