package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Booking;
import com.example.ceresto.eat.model.Customer;
import com.example.ceresto.eat.model.DiningTable;
import com.example.ceresto.eat.repository.CustomerRepository;
import com.example.ceresto.eat.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer, @RequestParam String username) {
        customer.setCreatedBy(username);
        customer.setCreatedDate(LocalDateTime.now());
        customer.setLastModifiedBy(username);
        customer.setLastModifiedDate(LocalDateTime.now());
        customerRepository.saveAndFlush(customer);
        return ResponseEntity.ok("Customer created successfully");
    }

    @GetMapping("/get-all")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Customer> getById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @GetMapping ("/get-active-records")
    public Optional<List<Customer>> getActiveRecords(){
        return customerService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Customer customer, @RequestParam String username){
        customerRepository.deleteById(id);
        customer.setLastModifiedBy(username);
        customer.setLastModifiedDate(LocalDateTime.now());
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer with id "+ id + " updated successfully");
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
        if (customerToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            customerToSet.setStatus(StatusEnum.DELETED);
        } else customerToSet.setStatus(StatusEnum.ACTIVE);
        customerRepository.updateStatusById(customerToSet.getStatus(), id);

        return ResponseEntity.ok("Customer with id " + id + "status changed to " + customerToSet.getStatus());
    }
    
    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<Optional<Customer>> getByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(customerRepository.getFromName(name), HttpStatus.OK);
    }


}
