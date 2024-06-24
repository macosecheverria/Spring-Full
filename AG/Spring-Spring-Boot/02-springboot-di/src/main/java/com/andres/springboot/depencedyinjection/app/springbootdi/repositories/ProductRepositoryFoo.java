package com.andres.springboot.depencedyinjection.app.springbootdi.repositories;

import  java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.andres.springboot.depencedyinjection.app.springbootdi.models.Product;

@Repository("productFoo")
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> findAll() {
    
        return Collections.singletonList(new Product(1L, "Mackbook air 14 pulgadas", 2000L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Mackbook air 12", 2000L);
    }

}
