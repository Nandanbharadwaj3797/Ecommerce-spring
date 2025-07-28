package com.example.ecommercespring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public String getCategory(){
        return "Electronics";
    }

    @PostMapping
    public String getPostCategory(){
        return " post Electronics";
    }

    @GetMapping("/count") //if we call a get request on /api/categories/count
    public int getCategoryCount(){
        return 1;
    }

    @DeleteMapping
    public String deleteCategory(){
        return "deleted categories";
    }
}
