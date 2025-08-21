package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;

import java.util.List;

public interface IProductService {

    ProductDto getProductById(Long id)throws Exception;

    ProductDto createProduct(ProductDto productDto)throws Exception;

    ProductWithCategoryDTO getProductWithCategory(Long id) throws  Exception;

    List<ProductDto> getProductsByIds(List<Long> ids);
}

