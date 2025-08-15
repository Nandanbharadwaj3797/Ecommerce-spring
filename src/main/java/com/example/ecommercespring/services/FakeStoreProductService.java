package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.gateway.IProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService {

    private final IProductGateway productGateway;

    @Autowired
    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception {
        return productGateway.getProductById(id);
    }

    public ProductDto createProduct(ProductDto productDto){
        return null;
    }

    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception{
        return null;
    }
}
