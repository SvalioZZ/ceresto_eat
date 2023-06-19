package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@Table
public class Order extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Temporal(TIMESTAMP)
    private LocalDate date;

    @OneToMany
    private DiningTable diningTable;

    @JsonBackReference
    @ManyToOne
    private Course course;


    public Order(StatusEnum status, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate, Long id, DiningTable diningTable, Course course, LocalDate date) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.diningTable = diningTable;
        this.course = course;
        this.date = date;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiningTable getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
