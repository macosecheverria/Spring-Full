package com.marcos.spring.fhrestddd.app.fhrestddd.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class BindingValidation {

    public static ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.status(400).body(errors);
    }

}