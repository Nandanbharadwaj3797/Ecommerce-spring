package com.example.ecommercespring.services;
import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getByName(String name) throws IOException;

    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception;
}
