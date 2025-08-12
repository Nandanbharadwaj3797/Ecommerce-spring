package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDto;

public interface IProductService {

    ProductDto getProductById(Long id)throws Exception;

    ProductDto createProduct(ProductDto productDto)throws Exception;
}
