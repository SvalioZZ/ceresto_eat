package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.RecordStatus;
import com.example.ceresto.eat.model.Course;
import com.example.ceresto.eat.model.Customer;
import com.example.ceresto.eat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/create")
    public void create(@RequestBody Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @GetMapping("/get-all")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Customer> getById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Long id, @RequestBody Customer customer){
        customerRepository.deleteById(id);
        customerRepository.save(customer);
        return "Customer updated";
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @PatchMapping("/set-status/{id}")
    public ResponseEntity<String> setStatusById(@PathVariable Long id) {
        Customer customerToSet = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        if (customerToSet.getStatus().equals(RecordStatus.ACTIVE)) {
            customerToSet.setStatus(RecordStatus.DELETED);
        } else customerToSet.setStatus(RecordStatus.ACTIVE);
        customerRepository.updateStatusById(customerToSet.getStatus(), id);

        return ResponseEntity.ok("Customer with id " + id + "status changed to " + customerToSet.getStatus());
    }
    
    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<Optional<Course>> getByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(customerRepository.getFromName(name), HttpStatus.OK);
    }


}
