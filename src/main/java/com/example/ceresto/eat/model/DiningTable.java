package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.RecordStatus;
import jakarta.persistence.*;


@Entity
@Table
public class DiningTable extends Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    @Column(nullable = false)
    private Integer tableAvailability;

    @Column(nullable = false)
    private String description;

    public DiningTable(RecordStatus status, Long tableId, Integer tableAvailability, String description) {
        super(status);
        this.tableId = tableId;
        this.tableAvailability = tableAvailability;
        this.description = description;
    }

    public DiningTable() {
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
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
