package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.enumerati.IngredientTypeEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Ingredient extends AuditableEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private IngredientTypeEnum type;
    
    @JsonBackReference
    @ManyToOne
    private Course course;

    public Ingredient(StatusEnum audit, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,
                      Long id, String name, String description, Double price, IngredientTypeEnum type, Course course) {
        super(audit, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
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

    public IngredientTypeEnum getType() {
        return type;
    }

    public void setType(IngredientTypeEnum type) {
        this.type = type;
    }
}
