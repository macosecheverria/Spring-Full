package com.andres.springboot.app.springbootcrud.domain.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andres.springboot.app.springbootcrud.domain.interfaces.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistDBValidation implements ConstraintValidator<IsExistDB, String> {

    @Autowired
    ProductService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !this.service.existBySku(value);
    }

}
