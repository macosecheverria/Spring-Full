package com.spring.aplicandobuenaspracticas.jpamysql.services;

import java.util.List;

import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.CreateProductDto;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.ProductResponse;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.UpdateProductDto;

public interface ProductService {

    ProductResponse findById(Long id);

    List<ProductResponse> findAll();

    List<ProductResponse> findAllByCategoryId(Long id);

    ProductResponse save(CreateProductDto createProductDto);

    ProductResponse update(Long id, UpdateProductDto updateProductDto);

    void deleteById(Long id);

}
