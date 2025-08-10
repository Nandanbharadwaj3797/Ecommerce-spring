package com.example.ecommercespring.repository;

import com.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
