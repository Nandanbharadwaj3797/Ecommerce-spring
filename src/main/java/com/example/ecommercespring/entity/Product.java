package com.example.ecommercespring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    private String image;
    private String color;
    private int price; // Consider BigDecimal for money
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;

    /**
     * Relationship mapping:
     * - Each Product belongs to one Category.
     * - One Category can have many Products.
     * - Using LAZY fetch to load category only when needed.
     * - category_id column will be non-null (nullable = false).
     */
    //
    //Eager-> At the time you fetch the parent entity (SELECT Query), Hibernate will also fetch the associated entities (often with a join or multiple Selects).
    //Lazy ->Hibernate uses a proxy for the relation. The actual SELECT for the related data happens when you call a getter.
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
