package com.andres.curso.backendproduct.backendproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.andres.curso.backendproduct.backendproducts.entities.Product;

// Es para que cree todo automatico y no crear el services y los controllers
// @RepositoryRestResource(path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
