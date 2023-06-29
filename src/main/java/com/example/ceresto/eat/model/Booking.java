package com.example.ceresto.eat.model;


import com.example.ceresto.eat.enumerati.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "booking")
public class Booking extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    private Customer customer;

    @JsonBackReference
    @ManyToOne
    private DiningTable diningTable;
    
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Billing> billings;
    
    public Booking(StatusEnum status, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, Long id, Customer customer, DiningTable diningTable) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.customer = customer;
        this.diningTable = diningTable;
        this.billings = new ArrayList<>();
    }

    public Booking () {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public DiningTable getDiningTable() {
        return diningTable;
    }
    
    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }
    
    public List<Billing> getChecks() {
        return billings;
    }
    
    public void setChecks(List<Billing> billings) {
        this.billings = billings;
    }
}
