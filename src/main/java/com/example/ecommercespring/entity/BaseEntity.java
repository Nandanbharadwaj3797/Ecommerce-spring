package com.example.ecommercespring.entity;

// Importing JPA annotation like @Id @Column used for mapping class to a db Structure
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Instant Class from java Time Api > represent the timestamp in UTC
import java.time.Instant;

// is JPA annotation used to define the base class that contain the common field
// which will be inherited and mapped into child entity tables
// Unlike @entity > It does not get ITS own table

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private Instant updatedAt;

    // This method us automatically called before the entity is saved for the first time.
    @PrePersist
    protected void onCreated() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = Instant.now();
    }
}
