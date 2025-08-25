package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)//This annotation is used to enable Mockito for the test class with junit
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService; // Service under test

    @Test
    @DisplayName("Should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() {
        // Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        Category category3 = Category.builder().name("Cloths").build();
        category3.setId(3L);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        when(categoryRepository.findAll()).thenReturn(categories); // Mocked the repository to return the category

        // Act
        List<CategoryDTO> result = categoryService.getAllCategories(); // service is actually called

        // Assert
        assertEquals(result.size(),3);
        verify(categoryRepository,times(1)).findAll();
    }
}
