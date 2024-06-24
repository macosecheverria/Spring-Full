package com.andres.springboot.app.springbootcrud.domain.validations;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.andres.springboot.app.springbootcrud.domain.entities.Product;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "400", "El CAMPO name es requerido");

        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", "400", "EL CAMPO description es requerido");
        }

        if (product.getPrice() == null) {
            errors.rejectValue("price", "400", "El CAMPO price es requerido");
        }

        if (product.getPrice() < 5) {
            errors.rejectValue("price", "400", "El price tiene que ser menor o igual a 5");
        }

    }

}
