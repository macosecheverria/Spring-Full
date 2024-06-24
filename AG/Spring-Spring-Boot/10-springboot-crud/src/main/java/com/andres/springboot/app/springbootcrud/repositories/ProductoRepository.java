package com.andres.springboot.app.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.springboot.app.springbootcrud.entities.Product;

public interface ProductoRepository extends JpaRepository<Product, Long> {

    boolean existsBySku(String sku);
}
