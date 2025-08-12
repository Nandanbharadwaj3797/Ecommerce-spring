package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductDto getProductById(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
                // or //Product product=repo.findById(id)
                //  .oeElseThrow(()-> new Exception("product not found"));
                // return ProductDto dto=productMapper.toDto(product);

    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.toEntity(productDto);
        Product saved = repo.save(product);
        return ProductMapper.toDto(saved);
    }
}
