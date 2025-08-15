package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Category;
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
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDto productDto, Category category) {
        return Product.builder()
                .image(productDto.getImage())
                .color(productDto.getColor())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .discount(productDto.getDiscount())
                .model(productDto.getModel())
                .title(productDto.getTitle())
                .category(category)
                .brand(productDto.getBrand())
                .popular(productDto.isPopular())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product) {
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .category(CategoryMapper.toDto(product.getCategory()))
                .build();
    }


}

