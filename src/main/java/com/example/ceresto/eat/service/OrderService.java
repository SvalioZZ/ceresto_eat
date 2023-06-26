package com.example.ceresto.eat.service;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Comanda;
import com.example.ceresto.eat.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    
    @Autowired
    private ComandaRepository orderRepository;
    
    public OrderService(ComandaRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public Optional<Comanda> getOrderById(StatusEnum status) {
        return orderRepository.findByStatus(status);
    }
}
