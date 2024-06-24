package com.andres.springboot.app.springbootcrud.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.springboot.app.springbootcrud.domain.entities.Product;

@Repository
public interface ProductoRepository extends JpaRepository<Product, Long> {

    boolean existsBySku(String sku);
}
