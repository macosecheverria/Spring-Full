package com.andres.springboot.app.springbootcrud.domain.interfaces;

import java.util.List;
import java.util.Optional;

import com.andres.springboot.app.springbootcrud.domain.entities.Product;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Product updateById(Long id, Product product);

    void delete(Long id);

    boolean existBySku(String sku);

}