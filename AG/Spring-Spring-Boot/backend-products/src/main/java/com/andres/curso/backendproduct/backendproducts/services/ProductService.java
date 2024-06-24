package com.andres.curso.backendproduct.backendproducts.services;

import java.util.List;

import com.andres.curso.backendproduct.backendproducts.dtos.CreateProductDto;
import com.andres.curso.backendproduct.backendproducts.dtos.UpdateProductDto;
import com.andres.curso.backendproduct.backendproducts.entities.Product;

public interface ProductService {

    Product create(CreateProductDto createProductDto);

    List<Product> findAll();

    Product findById(Long id);

    Product update(Long id, UpdateProductDto updateProductDto);

    void remove(Long id);
}