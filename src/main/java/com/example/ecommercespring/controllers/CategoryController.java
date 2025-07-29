package com.example.ecommercespring.controllers;

import com.example.ecommercespring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public List<String> getAllCategory(){
        return this.categoryService.getAllCategories();
    }
}
