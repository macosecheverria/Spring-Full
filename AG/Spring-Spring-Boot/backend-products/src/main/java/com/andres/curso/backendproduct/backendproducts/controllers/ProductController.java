package com.andres.curso.backendproduct.backendproducts.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.backendproduct.backendproducts.dtos.CreateProductDto;
import com.andres.curso.backendproduct.backendproducts.dtos.UpdateProductDto;
import com.andres.curso.backendproduct.backendproducts.entities.Product;
import com.andres.curso.backendproduct.backendproducts.services.ProductService;

import jakarta.validation.Valid;

// @CrossOrigin(originPatterns = "*")
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody CreateProductDto createProductDto){ 
        Product product = this.productService.create(createProductDto);
        return ResponseEntity.status(201).body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> allProducts =  this.productService.findAll();
        return ResponseEntity.status(200).body(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product productId =  this.productService.findById(id);
        return ResponseEntity.status(200).body(productId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@Valid @RequestBody UpdateProductDto updateProductDto){
        Product productUpdate =this.productService.update(id, updateProductDto);
        return ResponseEntity.status(200).body(productUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id){
        this.productService.remove(id);
        return ResponseEntity.status(200).body("Product deleted");
    }
}
