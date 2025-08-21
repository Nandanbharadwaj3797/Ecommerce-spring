package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.exception.CategoryNotFoundException;
import com.example.ecommercespring.exception.ProductNotFoundException;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import com.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository repo, CategoryRepository categoryRepository) {
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    public ProductDto getProductById(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID "+ id +" not found"));
                // or //Product product=repo.findById(id)
                //  .oeElseThrow(()-> new Exception("product not found"));
                // return ProductDto dto=productMapper.toDto(product);

    }

    @Override
    public ProductDto createProduct(ProductDto productDto)throws Exception {
        Category category =categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(()->new CategoryNotFoundException("Category not found"));

        Product product = ProductMapper.toEntity(productDto, category);
        Product saved = repo.save(product);
        return ProductMapper.toDto(saved);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        Product product = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return  ProductMapper.toProductWithCategoryDTO(product);
    }

    public List<ProductDto> getProductsByIds(List<Long> ids) {
        List<Product> products = repo.findAllById(ids);
        return ProductMapper.toDtoList(products);
    }
}

