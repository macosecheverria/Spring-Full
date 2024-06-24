package com.andres.springboot.depencedyinjection.app.springbootdi.repositories;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.andres.springboot.depencedyinjection.app.springbootdi.models.Product;

@Primary
// @RequestScope
// @SessionScope 
@Repository("productList")
public class ProductRepositoryImpl implements IProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = List.of(
                new Product(1L, "Memoria Corsair 32gb", 300L),
                new Product(2L, "Cpu Intel Core i9", 1000L),
                new Product(3L, "Teclado Razer 65%", 180L),
                new Product(4L, "Motherboard Gigabyte", 480L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

}
