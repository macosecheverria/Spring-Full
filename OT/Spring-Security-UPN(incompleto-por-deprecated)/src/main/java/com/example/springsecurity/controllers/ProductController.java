package com.example.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.dtos.CreateProductDto;
import com.example.springsecurity.entity.Product;
import com.example.springsecurity.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = this.productService.findAll();

        if(products != null && !products.isEmpty()){
            return ResponseEntity.ok(products);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createOne(
            @Valid @RequestBody CreateProductDto createProductDto){
        Product newProduct =  this.productService.createOne(createProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    } 

}
