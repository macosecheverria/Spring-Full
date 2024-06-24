package com.spring.aplicandobuenaspracticas.jpamysql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.aplicandobuenaspracticas.jpamysql.models.entities.Category;
import com.spring.aplicandobuenaspracticas.jpamysql.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
 
    List<Product> findAllByCategory(Category category);

}
