package com.example.ceresto.eat.model;

import com.example.ceresto.eat.repository.CourseRepository;
import com.example.ceresto.eat.repository.IngredientRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "course_detail")
public class CourseDetail extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    
    public CourseDetail(Long id, Course course, Ingredient ingredient) {
        this.id = id;
        this.ingredient = ingredient;
        this.course = course;
    }
    
    public CourseDetail() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Ingredient getIngredient() {
        return ingredient;
    }
    
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
}
