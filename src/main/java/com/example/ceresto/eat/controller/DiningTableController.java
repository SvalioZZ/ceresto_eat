package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.RecordStatus;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.model.DiningTable;
import com.example.ceresto.eat.repository.DiningTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tables")
public class DiningTableController {
    @Autowired
    private DiningTableRepository diningTableRepository;

    @PostMapping("/create")
    public void create(@RequestBody DiningTable table) {
        diningTableRepository.saveAndFlush(table);
    }

    @GetMapping("/get-all")
    public List<DiningTable> getAll() {
        return diningTableRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<DiningTable> getById(@PathVariable Long id) {
        return diningTableRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Long id, @RequestBody DiningTable table){
        diningTableRepository.deleteById(id);
        diningTableRepository.save(table);
        return "Table updated";
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
        if (tableToSet.getStatus().equals(RecordStatus.ACTIVE)) {
            tableToSet.setStatus(RecordStatus.DELETED);
        } else tableToSet.setStatus(RecordStatus.ACTIVE);
        diningTableRepository.updateStatusById(tableToSet.getStatus(), id);

        return ResponseEntity.ok("Table with id " + id + "status changed to " + tableToSet.getStatus());
    }
    
    @GetMapping("/get-by-name/{name}")
    public List<Course> getByName(@PathVariable("name") String name) {
        return diningTableRepository.getFromName(name);
    }

}
