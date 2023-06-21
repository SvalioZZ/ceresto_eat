package com.example.ceresto.eat.component;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Orders;
import com.example.ceresto.eat.repository.OrderRepository;
import com.example.ceresto.eat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryComponent extends OrderService {
    
    @Autowired
    public OrderRepositoryComponent(@Lazy OrderRepository orderRepository) {
        super(orderRepository);
    }
    
    @Override
    public Optional<Orders> getOrderById(StatusEnum status) {
        return super.getOrderById(status);
    }
}
