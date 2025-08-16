package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.services.IProductService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        try{
            ProductDto result=this.productService.getProductById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not found");
        }
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