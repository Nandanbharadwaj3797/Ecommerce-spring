package com.example.ecommercespring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;

    // one category has many products;
    //this does not mean that you're trying to store a list of products inside the Category table
    // telling jpa that relationship is already owned by the product Entity. so read from there
    @OneToMany(mappedBy ="category")
    private List<Product> products;
}
