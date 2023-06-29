package com.example.ceresto.eat.component;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Billing;
import com.example.ceresto.eat.repository.BillingRepo;
import com.example.ceresto.eat.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryComponent extends BillingService {
    
    @Autowired
    public OrderRepositoryComponent(@Lazy BillingRepo orderRepository) {
        super(orderRepository);
    }
    
    @Override
    public Optional<Billing> getOrderById(StatusEnum status) {
        return super.getOrderById(status);
    }
}
