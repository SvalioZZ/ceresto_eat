package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class Course extends AuditableEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private CourseTypeEnum type;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;
    
    @JsonBackReference
    @ManyToOne
    private Orders orders;


    public Course(Long id, String name, Double price, String description, CourseTypeEnum type,
                  StatusEnum status, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
        this.ingredients = new ArrayList<>();
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

    public CourseTypeEnum getType() {
        return type;
    }

    public void setType(CourseTypeEnum type) {
        this.type = type;
    }

    public String getInfo() {
       return id + "\nDescription: " + description + "\nPrice: " + price + "\nIngredients: " + ingredients;
    }

}
