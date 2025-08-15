package com.example.ecommercespring.services;


import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO>dtos = new ArrayList<>();
        for (Category category : repo.findAll()) {
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = repo.save(category);
        return CategoryMapper.toDto(saved);
    }

    @Override
    public CategoryDTO getByName(String name) throws IOException {
        Category category=repo.findByName(name)
                .orElseThrow(() -> new IOException("Category not found with name"+name));

        return CategoryMapper.toDto(category);
    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception {
        Category category=repo.findById(categoryId)
                .orElseThrow(() -> new Exception("Category not found with id"+categoryId));

        List<ProductDto> productDtos = category.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productDtos)
                .build();
    }
}
