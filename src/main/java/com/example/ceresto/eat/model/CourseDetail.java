package com.example.ceresto.eat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_detail")
public class CourseDetail extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    

    public CourseDetail(Long id) {
        this.id = id;
    }

    public CourseDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredients() {
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
