package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Comanda;
import com.example.ceresto.eat.repository.ComandaRepository;
import com.example.ceresto.eat.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comanda")
public class ComandaController {
    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private ComandaService comandaService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Comanda order, @RequestParam String username) {
        order.setCreatedBy(username);
        order.setCreatedDate(LocalDateTime.now());
        order.setLastModifiedBy(username);
        order.setLastModifiedDate(LocalDateTime.now());
        comandaRepository.saveAndFlush(order);
        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping("/get-all")
    public List<Comanda> getAll() {
        return comandaRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Comanda> getById(@PathVariable Long id) {
        return comandaRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Comanda order, @RequestParam String username){
        comandaRepository.deleteById(id);
        order.setLastModifiedBy(username);
        order.setLastModifiedDate(LocalDateTime.now());
        comandaRepository.save(order);
        return ResponseEntity.ok("Orders with id " + id + " updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        comandaRepository.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        comandaRepository.deleteAll();
    }

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        Comanda orderToSet = comandaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        if (orderToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            orderToSet.setStatus(StatusEnum.DELETED);
        } else orderToSet.setStatus(StatusEnum.ACTIVE);
        comandaRepository.updateStatusById(orderToSet.getStatus(), id);

        return ResponseEntity.ok("Ingredient with id " + id + "status changed to " + orderToSet.getStatus());
    }

}
