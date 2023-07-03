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
    public ResponseEntity<String> create(@RequestBody Billing billing, @RequestParam String username) {
        billing.setCreatedBy(username);
        billing.setCreatedDate(LocalDateTime.now());
        billing.setLastModifiedBy(username);
        billing.setLastModifiedDate(LocalDateTime.now());
        billingRepo.saveAndFlush(billing);
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

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Billing billing, @RequestParam String username){
        billing.setCreatedBy(billingRepo.getReferenceById(id).getCreatedBy());
        billing.setCreatedDate(billingRepo.getReferenceById(id).getCreatedDate());
        billing.setId(billingRepo.getReferenceById(id).getId());
        billing.setLastModifiedBy(username);
        billing.setLastModifiedDate(LocalDateTime.now());
        billingRepo.save(billing);
        billingRepo.deleteById(id);
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
        Billing billingToSet = billingRepo.findById(id).orElseThrow(() -> new RuntimeException("Billing not found"));
        if (billingToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            billingToSet.setStatus(StatusEnum.DELETED);
        } else billingToSet.setStatus(StatusEnum.ACTIVE);
        billingRepo.updateStatusById(billingToSet.getStatus(), id);

        return ResponseEntity.ok("Billing with id " + id + "status changed to " + billingToSet.getStatus());
    }

}
