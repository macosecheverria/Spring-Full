package com.andres.curso.backendproduct.backendproducts.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.curso.backendproduct.backendproducts.dtos.CreateProductDto;
import com.andres.curso.backendproduct.backendproducts.dtos.UpdateProductDto;
import com.andres.curso.backendproduct.backendproducts.entities.Product;
import com.andres.curso.backendproduct.backendproducts.exceptions.ProductNotFoundExceptions;
import com.andres.curso.backendproduct.backendproducts.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Product create(CreateProductDto createProductDto) {
        Product product = new Product();

        product.setName(createProductDto.getName());
        product.setDescription(createProductDto.getDescription());
        product.setPrice(createProductDto.getPrice());

        this.productRepository.save(product);
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundExceptions());
    }

    
    @Override
    @Transactional
    public Product update(Long id, UpdateProductDto updateProductDto) {

        Product productUpdated = this.findById(id);

        productUpdated.setName(updateProductDto.getName());
        productUpdated.setDescription(updateProductDto.getDescription());
        productUpdated.setPrice(updateProductDto.getPrice());

        this.productRepository.save(productUpdated);
        return productUpdated;
    }
    
    @Override
    @Transactional
    public void remove(Long id) {
        Long personDeleted = this.findById(id).getId();

        this.productRepository.deleteById(personDeleted);
    }
}
