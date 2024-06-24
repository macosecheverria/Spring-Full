package com.example.springsecurity.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductDto {

    @Null(message = "The fiel id is not required")
    private Long id;

    @NotBlank(message = "The field name cannot be null or empty")
    private String name;

    @DecimalMin(value = "0.01", message = "The field price must be greater than 0.01")
    private BigDecimal price;

}
