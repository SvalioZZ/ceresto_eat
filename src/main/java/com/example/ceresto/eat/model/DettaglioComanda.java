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
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "comanda_id")
    private Comanda comanda;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;
    

    public DettaglioComanda(StatusEnum status, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, Long id) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
    }

    public DettaglioComanda () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Comanda getComanda() {
        return comanda;
    }
    
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
}
