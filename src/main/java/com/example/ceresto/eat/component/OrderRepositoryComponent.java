package com.example.ceresto.eat.component;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Comanda;
import com.example.ceresto.eat.repository.ComandaRepository;
import com.example.ceresto.eat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryComponent extends OrderService {
    
    @Autowired
    public OrderRepositoryComponent(@Lazy ComandaRepository orderRepository) {
        super(orderRepository);
    }
    
    @Override
    public Optional<Comanda> getOrderById(StatusEnum status) {
        return super.getOrderById(status);
    }
}
