package com.andres.curso.backendproduct.backendproducts.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductDto {
    @NotBlank(message = "The field name cannot be empty or null")
    private String name;

    @NotBlank(message = "The field description cannot be empty")
    private String description;

    @NotNull(message = "The field price cannot be null")
    private Long price;
}
