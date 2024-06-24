package com.andres.springboot.app.springbootcrud.domain.entities;

import com.andres.springboot.app.springbootcrud.domain.validations.IsExistDB;
import com.andres.springboot.app.springbootcrud.domain.validations.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 15, message = "El minimo de letras es 3 y el maximo es 15")
    @NotBlank(message = "es requerido")
    private String name;

    @Min(value = 5, message = "debe de ser mayor o igual a 5")
    @NotNull
    private Integer price;

    @Size(min = 10, max = 150)
    @IsRequired
    private String description;

    @NotBlank
    @IsExistDB
    private String sku;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
