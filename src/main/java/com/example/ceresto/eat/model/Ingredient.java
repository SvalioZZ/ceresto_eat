package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.IngredientTypeEnum;
import com.example.ceresto.eat.enumerati.RecordStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Ingredient extends Record{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;
    
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
    
    public Ingredient(RecordStatus status, Long ingredientId, String name, String description, Double price, IngredientTypeEnum type, Course course) {
        super(status);
        this.ingredientId = ingredientId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.course = course;
    }
    
    public Ingredient() {
    
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
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
