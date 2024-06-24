package com.andres.springboot.app.springbootcrud.domain.excepcions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
