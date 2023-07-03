package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import jakarta.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum type;

    public Course(Long id, String name, Double price, String description, CourseTypeEnum type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
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
    
    //    public List<BillingDetail> getBillingDetails() {
//        return billingDetails;
//    }
//
//    public void setBillingDetails(List<BillingDetail> billingDetails) {
//        this.billingDetails = billingDetails;
//    }
//
    //    public String getInfo() {
//       return id + "\nDescription: " + description + "\nPrice: " + price + "\nIngredients: " + ingredients;
//    }

}
