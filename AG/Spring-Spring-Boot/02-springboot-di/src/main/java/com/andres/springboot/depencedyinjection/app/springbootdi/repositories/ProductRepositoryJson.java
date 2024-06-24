package com.andres.springboot.depencedyinjection.app.springbootdi.repositories;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.andres.springboot.depencedyinjection.app.springbootdi.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements IProductRepository {

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            this.list = List.of(mapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(el -> el.getId().equals(id)).findFirst().orElse(null);
    }

}
