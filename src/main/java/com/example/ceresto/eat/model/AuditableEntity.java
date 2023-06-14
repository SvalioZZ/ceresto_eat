package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.AuditEnum;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AuditableEntity {
    @Column(nullable = false)
    private AuditEnum audit;

    public AuditableEntity(AuditEnum audit) {
        this.audit = audit;
    }
    
    public AuditableEntity() {
    }
    
    public AuditEnum getAudit() {
        return audit;
    }

    public void setAudit(AuditEnum audit) {
        this.audit = audit;
    }
}
