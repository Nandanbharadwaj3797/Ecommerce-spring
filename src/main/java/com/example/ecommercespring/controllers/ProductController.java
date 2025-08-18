package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService  productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id)throws Exception{

        ProductDto result=this.productService.getProductById(id);
        return ResponseEntity.ok(result);

    }
    @PostMapping
    public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto productDto)throws Exception{
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO>getProductWithCategory(@PathVariable Long id)throws Exception{
        ProductWithCategoryDTO dto =  productService.getProductWithCategory(id);
        return ResponseEntity.ok(dto);
    }


}