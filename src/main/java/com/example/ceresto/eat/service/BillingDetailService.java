package com.example.ceresto.eat.service;


import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.BillingDetail;
import com.example.ceresto.eat.repository.BillingDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingDetailService {

    @Autowired
    private BillingDetailRepo billingDetailRepo; {
        this.billingDetailRepo = billingDetailRepo;
    }

    public Optional<BillingDetail> getByStatus(StatusEnum status) {
        return billingDetailRepo.findByStatus(status);
    }
}
