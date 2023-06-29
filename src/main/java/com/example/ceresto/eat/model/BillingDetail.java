package com.example.ceresto.eat.model;


import com.example.ceresto.eat.enumerati.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "billing_detail")
public class BillingDetail extends AuditableEntity{


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "billing_id")
    private Billing billing;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;
    

    public BillingDetail(StatusEnum status, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, Long id) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
    }

    public BillingDetail() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Billing getCheck() {
        return billing;
    }
    
    public void setCheck(Billing billing) {
        this.billing = billing;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
}
