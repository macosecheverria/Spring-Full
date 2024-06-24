package com.andres.springboot.app.springbootcrud.domain.validations;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidations implements ConstraintValidator<IsRequired, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // if(value != null && !value.isEmpty() && !value.isBlank()){
        // return true;
        // }

        // return false;

        return StringUtils.hasText(value);

    }

}
