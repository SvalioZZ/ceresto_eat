package com.example.ceresto.eat.service;

import com.example.ceresto.eat.model.Customer;
import com.example.ceresto.eat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
   public Optional<Customer> getCustomerFromId(Long id) {
       return Optional.of(customerRepository.getReferenceById(id));
   }
}
