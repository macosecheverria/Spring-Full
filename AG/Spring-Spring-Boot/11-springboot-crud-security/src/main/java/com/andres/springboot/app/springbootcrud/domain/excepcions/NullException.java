package com.andres.springboot.app.springbootcrud.domain.excepcions;

public class NullException extends RuntimeException {
    public NullException(String message){
        super(message);
    }
}
