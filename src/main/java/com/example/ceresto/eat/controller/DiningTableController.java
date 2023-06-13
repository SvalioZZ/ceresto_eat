package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.DiningTable;
import com.example.ceresto.eat.repository.DiningTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tables")
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
    public String update(@PathVariable Long id, @RequestBody DiningTable table){
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


}
