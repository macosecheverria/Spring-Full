package com.andres.springboot.depencedyinjection.app.springbootdi.services;

import java.util.List;

import com.andres.springboot.depencedyinjection.app.springbootdi.models.Product;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
