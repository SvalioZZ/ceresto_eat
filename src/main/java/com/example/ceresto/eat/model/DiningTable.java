package com.example.ceresto.eat.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "diningTable")
public class DiningTable extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Integer tableNumber;
    
    @Column(nullable = false)
    private Boolean reserved;
    
    @Column(nullable = false)
    private Integer seats;

    @OneToMany(mappedBy = "diningTable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;
    
    public DiningTable(Long id, Integer tableNumber, Boolean reserved, Integer seats) {
        this.id = id;
        this.tableNumber = tableNumber;
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
    
    public Integer getTableNumber() {
        return tableNumber;
    }
    
    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }
    
    public List<Booking> getBookings() {
        return bookings;
    }
    
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
