package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.RecordStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Course extends Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;
    
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;
    

    public Course(RecordStatus status, Long id, String name, Double price, String description) {
        super(RecordStatus.ACTIVE);
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Course() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getInfo() {
       return id + "\nDescription: " + description + "\nPrice: " + price + "\nIngredients: " + ingredients;
    }
    
}
