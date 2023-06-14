package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.RecordStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Course extends Record {
    
    //TODO solo Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

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
    

    public Course(RecordStatus status, Long courseId, String name, Double price, String description, CourseTypeEnum type) {
        super(status);
        this.courseId = courseId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public Course() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
       return courseId + "\nDescription: " + description + "\nPrice: " + price + "\nIngredients: " + ingredients;
    }

}
