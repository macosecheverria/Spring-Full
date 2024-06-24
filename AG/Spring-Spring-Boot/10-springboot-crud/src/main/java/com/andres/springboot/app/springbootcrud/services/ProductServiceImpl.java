package com.andres.springboot.app.springbootcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.springboot.app.springbootcrud.domain.excepcions.NotFoundException;
import com.andres.springboot.app.springbootcrud.domain.excepcions.NullException;
import com.andres.springboot.app.springbootcrud.domain.interfaces.ProductService;
import com.andres.springboot.app.springbootcrud.entities.Product;
import com.andres.springboot.app.springbootcrud.repositories.ProductoRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductoRepository repository;

    public ProductServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Product save(Product product) {

        if (product == null) {
            throw new NullException("The object is null");
        }

        return this.repository.save(product);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {

        if (id == null) {
            throw new NullException("The object is null");
        }
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public Product updateById(Long id, Product person) {

        if (id == null) {
            throw new NullException("The object is null");
        }

        Optional<Product> existProduct = this.repository.findById(id);

        if (!existProduct.isPresent()) {
            throw new NotFoundException("Product id Not found");
        }

        Product productUpdated = existProduct.get();

        productUpdated.setName(person.getName());
        productUpdated.setDescription(person.getDescription());
        productUpdated.setPrice(person.getPrice());
        productUpdated.setSku(person.getSku());
        this.repository.save(productUpdated);

        return productUpdated;
    }

    @Transactional
    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new NullException("The object is null");
        }

        Optional<Product> existProduct = this.repository.findById(id);

        if (!existProduct.isPresent()) {
            throw new NotFoundException("Product id not found");
        }

        this.repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existBySku(String sku) {
        return this.repository.existsBySku(sku);

    }

}
