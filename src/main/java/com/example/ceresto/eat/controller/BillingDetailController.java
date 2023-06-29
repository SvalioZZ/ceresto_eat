package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.BillingDetail;
import com.example.ceresto.eat.repository.BillingDetailRepo;
import com.example.ceresto.eat.service.BillingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billing-detail")
public class BillingDetailController {

    @Autowired
    private BillingDetailRepo billingDetailRepo;

    @Autowired
    private BillingDetailService billingDetailService;

    @PostMapping("/create")
    public ResponseEntity<String> createBillingDetail(@RequestBody BillingDetail billingDetail, @RequestParam String username) {
        billingDetail.setCreatedBy(username);
        billingDetail.setCreatedDate(LocalDateTime.now());
        billingDetail.setLastModifiedBy(username);
        billingDetail.setLastModifiedDate(LocalDateTime.now());
        billingDetailRepo.saveAndFlush(billingDetail);
        return ResponseEntity.ok("Billing Detail created successfully");
    }

    @GetMapping("/get-all")
    public List<BillingDetail> getAll() {
        return billingDetailRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<BillingDetail> getById(@PathVariable Long id) {
        return billingDetailRepo.findById(id);
    }

    @GetMapping("/get-active-records")
    public Optional<BillingDetail> getActiveRecords() {
        return billingDetailService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody BillingDetail billingDetail, @RequestParam String username) {
        billingDetailRepo.deleteById(id);
        billingDetail.setLastModifiedBy(username);
        billingDetail.setLastModifiedDate(LocalDateTime.now());
        billingDetailRepo.save(billingDetail);
        return ResponseEntity.ok("Billing Detail with id " + id + " updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        billingDetailRepo.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        billingDetailRepo.deleteAll();
    }

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        BillingDetail billingDetailToSet = billingDetailRepo.findById(id).orElseThrow(() -> new RuntimeException("BillingDetail not found"));
        if (billingDetailToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            billingDetailToSet.setStatus(StatusEnum.DELETED);
        } else billingDetailToSet.setStatus(StatusEnum.ACTIVE);
        billingDetailRepo.updateStatusById(billingDetailToSet.getStatus(), id);

        return ResponseEntity.ok("Billing Detail with id " + id + "status changed to " + billingDetailToSet.getStatus());
    }


}
