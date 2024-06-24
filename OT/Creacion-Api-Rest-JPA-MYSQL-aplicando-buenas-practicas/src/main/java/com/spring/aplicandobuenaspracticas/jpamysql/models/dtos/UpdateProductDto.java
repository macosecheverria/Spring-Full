package com.spring.aplicandobuenaspracticas.jpamysql.models.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateProductDto {

    @NotBlank(message = "The field name cannot be empty or null")
    private String name;

    @NotBlank(message = "The field description cannot be empty or null")
    private String description;

    @NotNull(message = "The field price cannot be null")
    private BigDecimal price;

    @NotNull(message = "The filed category id cannot be null")
    private Long categoryId;
}
