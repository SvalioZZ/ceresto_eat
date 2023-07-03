package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.DiningTable;
import com.example.ceresto.eat.repository.DiningTableRepository;
import com.example.ceresto.eat.service.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tables")
public class DiningTableController {
    @Autowired
    private DiningTableRepository diningTableRepository;
    @Autowired
    private DiningTableService diningTableService;
    
    public DiningTableController(DiningTableRepository diningTableRepository, DiningTableService diningTableService) {
        this.diningTableRepository = diningTableRepository;
        this.diningTableService = diningTableService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody DiningTable table, @RequestParam String username) {
        table.setCreatedBy(username);
        table.setCreatedDate(LocalDateTime.now());
        table.setLastModifiedBy(username);
        table.setLastModifiedDate(LocalDateTime.now());
        diningTableRepository.saveAndFlush(table);
        return ResponseEntity.ok("Table created successfully");
    }

    @GetMapping("/get-all")
    public List<DiningTable> getAll() {
        return diningTableRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<DiningTable> getById(@PathVariable Long id) {
        return diningTableRepository.findById(id);
    }

    @GetMapping ("/get-active-records")
    public Optional<List<DiningTable>> getActiveRecords(){
        return diningTableService.getByStatus(StatusEnum.ACTIVE);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody DiningTable table, @RequestParam String username){
        table.setCreatedBy(diningTableRepository.getReferenceById(id).getCreatedBy());
        table.setCreatedDate(diningTableRepository.getReferenceById(id).getCreatedDate());
        table.setId(diningTableRepository.getReferenceById(id).getId());
        table.setLastModifiedBy(username);
        table.setLastModifiedDate(LocalDateTime.now());
        diningTableRepository.save(table);
        diningTableRepository.deleteById(id);
        return ResponseEntity.ok("Table with id " + id + " updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        diningTableRepository.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        diningTableRepository.deleteAll();
    }

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        DiningTable tableToSet = diningTableRepository.findById(id).orElseThrow(() -> new RuntimeException("Table not found"));
        if (tableToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            tableToSet.setStatus(StatusEnum.DELETED);
        } else tableToSet.setStatus(StatusEnum.ACTIVE);
        diningTableRepository.updateStatusById(tableToSet.getStatus(), id);

        return ResponseEntity.ok("Table with id " + id + "status changed to " + tableToSet.getStatus());
    }

}
