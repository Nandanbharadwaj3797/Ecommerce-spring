package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import com.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import com.example.ecommercespring.mappers.GetAllCategoriesMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {

    private final FakeStoreCategoryApi fakeStoreCategoryAPi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryAPi) {
        this.fakeStoreCategoryAPi = fakeStoreCategoryAPi;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        // 1. Make the HTTP request to the fakeStore API to fetch all categories
        FakeStoreCategoryResponseDTO response= this.fakeStoreCategoryAPi.getAllFakeCategory().execute().body();
        // check if response is null and throw an IO Exception if it is
        if(response==null) {
            throw new IOException("failed to fetch categories from fakeStore Api");
        }
        // map the response to a list of CategoryDTO object
        return GetAllCategoriesMapper.toCategoryDTO(response);

    }
}


