package com.spring.aplicandobuenaspracticas.jpamysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.aplicandobuenaspracticas.jpamysql.models.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
