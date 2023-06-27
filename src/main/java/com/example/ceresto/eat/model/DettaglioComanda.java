package com.example.ceresto.eat.model;


import com.example.ceresto.eat.enumerati.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "dettaglio_comanda")
public class DettaglioComanda extends AuditableEntity{


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (mappedBy = "dettaglio_comanda" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;

    @JsonBackReference
    @ManyToOne
    private Comanda comanda;

    public DettaglioComanda(StatusEnum status, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, Long id, List<Course> courses) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public DettaglioComanda () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
