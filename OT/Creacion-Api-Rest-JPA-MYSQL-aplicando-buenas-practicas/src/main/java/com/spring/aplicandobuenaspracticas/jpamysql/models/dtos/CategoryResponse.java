package com.spring.aplicandobuenaspracticas.jpamysql.models.dtos;

// import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

// @JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class CategoryResponse {
    
    private Long id;
    private String name;
    private String description;

}
