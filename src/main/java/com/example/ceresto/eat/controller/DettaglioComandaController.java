package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.DettaglioComanda;
import com.example.ceresto.eat.repository.DettaglioComandaRepository;
import com.example.ceresto.eat.service.DettaglioComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dettaglio-comanda")
public class DettaglioComandaController {

    @Autowired
    private DettaglioComandaRepository dettaglioComandaRepository;

    @Autowired
    private DettaglioComandaService dettaglioComandaService;

    @PostMapping("/create")
    public ResponseEntity<String> createDettaglioComanda(@RequestBody DettaglioComanda dettaglioComanda, @RequestParam String username) {
        dettaglioComanda.setCreatedBy(username);
        dettaglioComanda.setCreatedDate(LocalDateTime.now());
        dettaglioComanda.setLastModifiedBy(username);
        dettaglioComanda.setLastModifiedDate(LocalDateTime.now());
        dettaglioComandaRepository.saveAndFlush(dettaglioComanda);
        return ResponseEntity.ok("Course Details created successfully");
    }

    @GetMapping("/get-all")
    public List<DettaglioComanda> getAll() {
        return dettaglioComandaRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<DettaglioComanda> getById(@PathVariable Long id) {
        return dettaglioComandaRepository.findById(id);
    }

    @GetMapping("/get-active-records")
    public Optional<DettaglioComanda> getActiveRecords() {
        return dettaglioComandaService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody DettaglioComanda dettaglioComanda, @RequestParam String username) {
        dettaglioComandaRepository.deleteById(id);
        dettaglioComanda.setLastModifiedBy(username);
        dettaglioComanda.setLastModifiedDate(LocalDateTime.now());
        dettaglioComandaRepository.save(dettaglioComanda);
        return ResponseEntity.ok("DettaglioComanda with id " + id + " updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        dettaglioComandaRepository.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        dettaglioComandaRepository.deleteAll();
    }

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        DettaglioComanda dettaglioComandaToSet = dettaglioComandaRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        if (dettaglioComandaToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            dettaglioComandaToSet.setStatus(StatusEnum.DELETED);
        } else dettaglioComandaToSet.setStatus(StatusEnum.ACTIVE);
        dettaglioComandaRepository.updateStatusById(dettaglioComandaToSet.getStatus(), id);

        return ResponseEntity.ok("DettaglioComanda with id " + id + "status changed to " + dettaglioComandaToSet.getStatus());
    }


}
