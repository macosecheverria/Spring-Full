package com.spring.aplicandobuenaspracticas.jpamysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.ProductResponse;
import com.spring.aplicandobuenaspracticas.jpamysql.models.entities.Product;

import static com.spring.aplicandobuenaspracticas.jpamysql.utils.Constants.*;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    @Mapping(target = "status", expression = "java(mapStatus(product))")
    ProductResponse toProductResponse(Product product);

    default String mapStatus(Product product) {
        return product.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }

}
