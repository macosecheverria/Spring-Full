package com.andres.springboot.depencedyinjection.app.springbootdi.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.depencedyinjection.app.springbootdi.models.Product;
import com.andres.springboot.depencedyinjection.app.springbootdi.services.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    private IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    public Product byId(@PathVariable Long id) {
        return service.findById(id);
    }

}
