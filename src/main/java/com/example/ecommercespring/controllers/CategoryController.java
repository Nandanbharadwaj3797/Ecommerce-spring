package com.example.ecommercespring.controllers;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory() throws IOException {
        List<CategoryDTO>result= this.categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO  categoryDTO) {

        throw new UnsupportedOperationException("Method not yet implemented");
    }
}
