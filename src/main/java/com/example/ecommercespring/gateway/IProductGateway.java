package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.ProductDto;

import java.io.IOException;

public interface IProductGateway {
    ProductDto getProductById(Long id) throws Exception;
}

