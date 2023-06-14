package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.RecordStatus;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

//TODO AuditableEntity come nome per la classe

@MappedSuperclass
public class Record {
    @Column(nullable = false)
    private RecordStatus status;

    public Record(RecordStatus status) {
        this.status = status;
    }

    public Record() {
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }
}
