package com.spring.aplicandobuenaspracticas.jpamysql.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.aplicandobuenaspracticas.jpamysql.exceptions.CategoryNotFoundException;
import com.spring.aplicandobuenaspracticas.jpamysql.exceptions.ProductNotFoundException;
import com.spring.aplicandobuenaspracticas.jpamysql.mapper.ProductMapper;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.CreateProductDto;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.ProductResponse;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.UpdateProductDto;
import com.spring.aplicandobuenaspracticas.jpamysql.models.entities.Product;
import com.spring.aplicandobuenaspracticas.jpamysql.repositories.CategoryRepository;
import com.spring.aplicandobuenaspracticas.jpamysql.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse findById(Long id) {
        return this.productRepository.findById(id)
                .map(this.productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return this.productRepository.findAll()
                .stream()
                .map(this.productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findAllByCategoryId(Long id) {
        return this.categoryRepository.findById(id)
                .map(category -> this.productRepository.findAllByCategory(category))
                .map(products -> products.stream()
                        .map(this.productMapper::toProductResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public ProductResponse save(CreateProductDto createProductDto) {
        return this.categoryRepository.findById(createProductDto.getCategoryId())
                .map(category -> {

                    Product product = new Product();
                    product.setName(createProductDto.getName());
                    product.setDescription(createProductDto.getDescription());
                    product.setPrice(createProductDto.getPrice());
                    product.setCategory(category);
                    product.setStatus(Boolean.TRUE);

                    return this.productRepository.save(product);
                })
                .map(this.productMapper::toProductResponse)
                .orElseThrow(CategoryNotFoundException::new);

    }

    @Override
    public ProductResponse update(Long id, UpdateProductDto updateProductDto) {
        return this.productRepository.findById(id)
                .map(product -> this.categoryRepository
                        .findById(updateProductDto.getCategoryId())
                        .map(category -> {
                            product.setName(updateProductDto.getName());
                            product.setDescription(updateProductDto.getDescription());
                            product.setPrice(updateProductDto.getPrice());
                            product.setCategory(category);
                            return this.productRepository.save(product);
                        })
                        .orElseThrow(CategoryNotFoundException::new))
                .map(this.productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(this.productRepository.findById(id).isEmpty()){
            throw new ProductNotFoundException();
        }

        this.productRepository.deleteById(id);
    }

}
