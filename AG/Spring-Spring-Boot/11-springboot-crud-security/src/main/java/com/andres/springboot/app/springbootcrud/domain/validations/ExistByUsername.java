package com.andres.springboot.app.springbootcrud.domain.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistByUsernameValidation.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistByUsername {
    String message() default "El username ya existe en la base de datos, escriba otro username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}