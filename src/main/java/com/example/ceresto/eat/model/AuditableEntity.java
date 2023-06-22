package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.StatusEnum;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    
    @CreatedBy
    private String createdBy;
    
    @CreatedDate
    @Temporal(TIMESTAMP)
    public Date createdDate;

    
    @LastModifiedBy
    private String lastModifiedBy;

    
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date lastModifiedDate;

    public AuditableEntity(StatusEnum status, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public AuditableEntity() {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
