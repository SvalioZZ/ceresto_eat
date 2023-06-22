package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date date;

    @ManyToOne(targetEntity = DiningTable.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DiningTable diningTable;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;


    public Orders(StatusEnum status, Long id, DiningTable diningTable, List<Course> courses,
                  Date date,String createdBy,Date createdDate,String lastModifiedBy,Date lastModifiedDate ) {
        super(status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.diningTable = diningTable;
        this.courses = courses;
        this.date = date;
    }

    public Orders() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
