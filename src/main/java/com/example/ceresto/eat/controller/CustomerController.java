package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.model.Customer;
import com.example.ceresto.eat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/create")
    public void create(@RequestBody Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Customer> getById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Customer customer){
        customerRepository.deleteById(id);
        customerRepository.save(customer);
        return "Customer updated";
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        customerRepository.deleteAll();
    }


}
