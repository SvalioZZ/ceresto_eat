package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Orders;
import com.example.ceresto.eat.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Orders order, @RequestParam String username) {
        order.setCreatedBy(username);
        order.setCreatedDate(LocalDate.now());
        order.setLastModifiedBy(username);
        order.setLastModifiedDate(LocalDate.now());
        orderRepository.saveAndFlush(order);
        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping("/get-all")
    public List<Orders> getAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Orders> getById(@PathVariable Long id) {
        return orderRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Orders order, @RequestParam String username){
        orderRepository.deleteById(id);
        order.setLastModifiedBy(username);
        order.setLastModifiedDate(LocalDate.now());
        orderRepository.save(order);
        return ResponseEntity.ok("Orders with id " + id + " updated successfully");
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
        Orders orderToSet = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        if (orderToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            orderToSet.setStatus(StatusEnum.DELETED);
        } else orderToSet.setStatus(StatusEnum.ACTIVE);
        orderRepository.updateStatusById(orderToSet.getStatus(), id);

        return ResponseEntity.ok("Ingredient with id " + id + "status changed to " + orderToSet.getStatus());
    }

}
