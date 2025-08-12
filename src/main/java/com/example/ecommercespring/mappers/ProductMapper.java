package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product  product) {
        return ProductDto.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDto productDto) {
        return Product.builder()
                .image(productDto.getImage())
                .color(productDto.getColor())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .discount(productDto.getDiscount())
                .model(productDto.getModel())
                .title(productDto.getTitle())
                .category(productDto.getCategory())
                .brand(productDto.getBrand())
                .popular(productDto.isPopular())
                .build();
    }
}

