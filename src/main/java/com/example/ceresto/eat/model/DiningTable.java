package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.RecordStatus;
import jakarta.persistence.*;


@Entity
@Table
public class DiningTable extends Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tableId;

    @Column(nullable = false)
    private Integer tableAvailability;

    @Column(nullable = false)
    private String description;

    public DiningTable(Integer tableId, Integer tableAvailability, String description) {
        super(RecordStatus.ACTIVE);
        this.tableId = tableId;
        this.tableAvailability = tableAvailability;
        this.description = description;
    }

    public DiningTable() {
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
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
