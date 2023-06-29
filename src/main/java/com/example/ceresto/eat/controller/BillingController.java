package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Billing;
import com.example.ceresto.eat.repository.BillingRepo;
import com.example.ceresto.eat.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
    @Autowired
    private BillingRepo billingRepo;

    @Autowired
    private BillingService billingService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Billing order, @RequestParam String username) {
        order.setCreatedBy(username);
        order.setCreatedDate(LocalDateTime.now());
        order.setLastModifiedBy(username);
        order.setLastModifiedDate(LocalDateTime.now());
        billingRepo.saveAndFlush(order);
        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping("/get-all")
    public List<Billing> getAll() {
        return billingRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Billing> getById(@PathVariable Long id) {
        return billingRepo.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Billing billing, @RequestParam String username){
        billingRepo.deleteById(id);
        billing.setLastModifiedBy(username);
        billing.setLastModifiedDate(LocalDateTime.now());
        billingRepo.save(billing);
        return ResponseEntity.ok("Billing with id " + id + " updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        billingRepo.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        billingRepo.deleteAll();
    }

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        Billing orderToSet = billingRepo.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        if (orderToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            orderToSet.setStatus(StatusEnum.DELETED);
        } else orderToSet.setStatus(StatusEnum.ACTIVE);
        billingRepo.updateStatusById(orderToSet.getStatus(), id);

        return ResponseEntity.ok("Ingredient with id " + id + "status changed to " + orderToSet.getStatus());
    }

}
