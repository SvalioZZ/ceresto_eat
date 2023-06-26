package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "diningTable")
public class DiningTable extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Boolean reserved;
    
    @Column(nullable = false)
    private Integer seats;
    
    @JsonBackReference
    @OneToMany(mappedBy = "diningTable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> orders;
    
    @OneToOne(mappedBy = "diningTable")
    private Customer customer;
    
    public DiningTable(StatusEnum status, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, Long id, Boolean reserved, Integer seats) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.reserved = reserved;
        this.seats = seats;
    }
    
    public DiningTable() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Boolean getReserved() {
        return reserved;
    }
    
    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }
    
    public Integer getSeats() {
        return seats;
    }
    
    public void setSeats(Integer seats) {
        this.seats = seats;
    }
    
    public List<Orders> getOrders() {
        return orders;
    }
    
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
