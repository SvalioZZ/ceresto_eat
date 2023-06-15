package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table
public class DiningTable extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer tableAvailability;

    @Column(nullable = false)
    private String description;

    public DiningTable(StatusEnum audit, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,
                       Long id, Integer tableAvailability, String description) {
        super(audit, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.tableAvailability = tableAvailability;
        this.description = description;
    }

    public DiningTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTableAvailability() {
        return tableAvailability;
    }

    public void setTableAvailability(Integer tableAvailability) {
        this.tableAvailability = tableAvailability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
