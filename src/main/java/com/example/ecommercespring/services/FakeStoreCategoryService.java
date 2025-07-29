package com.example.ecommercespring.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {
    @Override
    public List<String>getAllCategories(){
        return List.of();
    }


}
