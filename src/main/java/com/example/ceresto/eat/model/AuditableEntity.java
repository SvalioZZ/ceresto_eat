package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
public class AuditableEntity {
    @Hidden
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    
    @Hidden
    @Column(nullable = false)
    private String createdBy;
    
    @Hidden
    @Column(nullable = false)
    private LocalDateTime createdDate;

    
    @Hidden
    @Column(nullable = false)
    private String lastModifiedBy;

    
    @Hidden
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

    public AuditableEntity() {
        this.status = StatusEnum.ACTIVE;
    }

  

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
