package com.example.ecommercespring.controllers;

import com.example.ecommercespring.services.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private ICategoryService categoryService;

    CategoryController(ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }

    @GetMapping
    public List<String> getAllCategory(){
        return this.categoryService.getAllCategories();
    }
}
