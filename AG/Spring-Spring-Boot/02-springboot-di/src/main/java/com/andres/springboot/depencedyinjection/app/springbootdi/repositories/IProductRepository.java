package com.andres.springboot.depencedyinjection.app.springbootdi.repositories;

import java.util.List;

import com.andres.springboot.depencedyinjection.app.springbootdi.models.Product;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
