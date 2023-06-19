package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Ingredient;
import com.example.ceresto.eat.model.Order;
import com.example.ceresto.eat.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/create")
    public void create(@RequestBody Order order) {
        orderRepository.saveAndFlush(order);
    }

    @GetMapping("/get-all")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Order> getById(@PathVariable Long id) {
        return orderRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Long id, @RequestBody Order order){
        orderRepository.deleteById(id);
        orderRepository.save(order);
        return "Order updated";
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        Order orderToSet = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        if (orderToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            orderToSet.setStatus(StatusEnum.DELETED);
        } else orderToSet.setStatus(StatusEnum.ACTIVE);
        orderRepository.updateStatusById(orderToSet.getStatus(), id);

        return ResponseEntity.ok("Ingredient with id " + id + "status changed to " + orderToSet.getStatus());
    }

}
