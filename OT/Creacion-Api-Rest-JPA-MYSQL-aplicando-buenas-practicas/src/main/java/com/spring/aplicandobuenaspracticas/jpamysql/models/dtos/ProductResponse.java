package com.spring.aplicandobuenaspracticas.jpamysql.models.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryResponse category;
    private String status;

}
