package com.andres.springboot.app.springbootcrud.presentacion.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.app.springbootcrud.domain.entities.Product;
import com.andres.springboot.app.springbootcrud.domain.interfaces.ProductService;

import jakarta.validation.Valid;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Qualifier("productService")
    private ProductService service;

    // private ProductValidation validation;


    public ProductController(ProductService service /* , ProductValidation validation*/ ) {
        this.service = service;
        // this.validation = validation;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    private ResponseEntity<?> create(
            @Valid @NonNull @RequestBody Product product,
            @NonNull BindingResult result) {

        // this.validation.validate(product, result);

        if (result.hasFieldErrors()) {
            return this.validation(result);
        }

        Product newProduct = this.service.save(product);
        return ResponseEntity.status(200).body(newProduct);

    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    private ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.status(200).body(this.service.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Product> productId = this.service.findById(id);
        return ResponseEntity.status(200).body(productId.get());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private ResponseEntity<?> update(@Valid @NonNull @RequestBody Product product,@NonNull BindingResult result, @PathVariable Long id) {

        // this.validation.validate(product, result);

        if (result.hasFieldErrors()) {
            return this.validation(result);
        }

        Product productUpdated = this.service.updateById(id, product);

        return ResponseEntity.status(200).body(productUpdated);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        this.service.delete(id);
        Map<String, String> message = Map.of("message", "Product deleted");
        return ResponseEntity.status(200).body(message);

    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.status(400).body(errors);
    }

}
