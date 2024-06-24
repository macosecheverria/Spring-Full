package com.spring.aplicandobuenaspracticas.jpamysql.mapper;

import org.mapstruct.Mapper;

import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.CategoryResponse;
import com.spring.aplicandobuenaspracticas.jpamysql.models.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);

}
