package com.marcos.spring.fhrestddd.app.fhrestddd.domain.errors;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
