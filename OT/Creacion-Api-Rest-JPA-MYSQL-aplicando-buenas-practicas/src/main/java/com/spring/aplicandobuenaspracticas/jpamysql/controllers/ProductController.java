package com.spring.aplicandobuenaspracticas.jpamysql.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.CreateProductDto;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.ProductResponse;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.UpdateProductDto;
import com.spring.aplicandobuenaspracticas.jpamysql.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> product = this.productService.findAll();

        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        ProductResponse product = this.productService.findById(id);
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductResponse>> findAllByCategoryId(@PathVariable Long id) {
        List<ProductResponse> product = this.productService.findAllByCategoryId(id);
        return ResponseEntity.status(200).body(product);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody CreateProductDto createProductDto) {
        ProductResponse product = this.productService.save(createProductDto);

        return ResponseEntity.status(201).body(product);
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
            @Valid @RequestBody UpdateProductDto updateProductDto) {
        ProductResponse product = this.productService.update(id, updateProductDto);

        return ResponseEntity.status(200).body(product);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        this.productService.deleteById(id);
        return ResponseEntity.status(200).body("Product deleted");

    }

}
