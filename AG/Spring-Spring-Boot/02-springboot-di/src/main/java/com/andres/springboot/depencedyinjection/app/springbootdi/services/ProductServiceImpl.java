package com.andres.springboot.depencedyinjection.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.springboot.depencedyinjection.app.springbootdi.models.Product;
import com.andres.springboot.depencedyinjection.app.springbootdi.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private Environment env;
    
    private IProductRepository repository;

    public ProductServiceImpl(@Qualifier("productJson") IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> {
            Double priceTax = product.getPrice() * Double.parseDouble( env.getProperty("config.price.tax"));
            
            // Product newProduct = new Product(el.getId(), product.getName(),
            // priceTax.longValue());

            Product newProduct = (Product) product.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

            // product.setPrice(priceTax.longValue());
            // return product;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
