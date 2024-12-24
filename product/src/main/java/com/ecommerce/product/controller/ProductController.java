package com.ecommerce.product.controller;

import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/product/{product_id}")
    ResponseEntity<Product> getProduct(@PathVariable("product_id") Long id){
        return productService.getProduct(id);
    }

    @GetMapping("/api/products")
    ResponseEntity<List<Product>> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/api/product")
    ResponseEntity<Product> create(@RequestBody Product product){
        productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
