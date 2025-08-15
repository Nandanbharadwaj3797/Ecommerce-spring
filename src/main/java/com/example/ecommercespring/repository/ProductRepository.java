package com.example.ecommercespring.repository;

import com.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query using JPQL/HQL
    @Query("SELECT p FROM Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    // MySQL full-text search (native query)
    @Query(value = "SELECT * FROM product WHERE MATCH(name, description) AGAINST(:keyword)",nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);

    //:minPrice < "minPrice" in @Param("minPrice")
    //:brand < "brand" in @Param("brand")
    @Query("SELECT p FROM Product p WHERE p.price > :minPrice AND p.brand = :brand")
    List<Product> findByBrandAndPrice(
            @Param("minPrice") int minPrice,
            @Param("brand") String brand);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceRange(
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice);

    @Query("SELECT p FROM Product p WHERE p.brand = :brand")
    List<Product> findByBrand(@Param("brand") String brand);

}
