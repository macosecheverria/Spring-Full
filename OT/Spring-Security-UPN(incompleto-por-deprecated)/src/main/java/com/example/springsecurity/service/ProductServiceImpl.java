package com.example.springsecurity.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springsecurity.dtos.CreateProductDto;
import com.example.springsecurity.entity.Product;
import com.example.springsecurity.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private  ProductRepository productRepository;
    @Override
    @Transactional
    public Product createOne(CreateProductDto createProductDto) {
        Product product = new Product();

        product.setName(createProductDto.getName());
        product.setPrice(createProductDto.getPrice());

        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
    
}
