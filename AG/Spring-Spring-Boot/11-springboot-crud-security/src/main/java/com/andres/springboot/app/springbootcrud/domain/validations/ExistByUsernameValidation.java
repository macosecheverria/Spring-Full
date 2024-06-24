package com.andres.springboot.app.springbootcrud.domain.validations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.andres.springboot.app.springbootcrud.domain.interfaces.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByUsernameValidation  implements ConstraintValidator<ExistByUsername,String>{

    @Qualifier("userService")
    private  UserService userService;

    public ExistByUsernameValidation(){}

    public ExistByUsernameValidation(UserService userService){
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(this.userService == null) return true;
        return !this.userService.existsByUsername(value);

       
    }
    
}
