package com.example.springsecurity.service;

import java.util.List;

import com.example.springsecurity.dtos.CreateProductDto;
import com.example.springsecurity.entity.Product;

public interface ProductService {
    
    List<Product> findAll();

    Product createOne(CreateProductDto createProductDto);
    
}
