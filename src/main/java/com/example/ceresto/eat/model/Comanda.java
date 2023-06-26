package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "comanda")
public class Comanda extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime date;
    
    @ManyToOne(targetEntity = DiningTable.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DiningTable diningTable;

    @OneToMany(mappedBy = "comande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;
    
    
    public Comanda(StatusEnum status, Long id, DiningTable diningTable, List<Course> courses,
                   LocalDateTime date, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.diningTable = diningTable;
        this.courses = courses;
        this.date = date;
    }
    
    public Comanda() {
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
    
    public List<Course> getCourse() {
        return courses;
    }
    
    public void setCourse(List<Course> courses) {
        this.courses = courses;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
