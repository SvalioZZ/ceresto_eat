package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.RecordStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Ingredient extends Record{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Double price;
    
    @JsonBackReference
    @ManyToOne
    private Course course;
    
    public Ingredient(RecordStatus status, Long id, String name, String description, Double price, Course course) {
        super(status);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.course = course;
    }
    
    public Ingredient() {
    
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
}
