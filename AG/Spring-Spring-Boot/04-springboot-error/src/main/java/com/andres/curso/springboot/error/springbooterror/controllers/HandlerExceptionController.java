package com.andres.curso.springboot.error.springbooterror.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.andres.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.andres.curso.springboot.error.springbooterror.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> dividedByZero(Exception exception) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Cannot be divided by zero");
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Error> notFount(Exception exception) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("API rest url not found");
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(404).body(error);
    }

    // @ExceptionHandler(NumberFormatException.class)
    // public ResponseEntity<Error> parseIntException(Exception exception){
    // Error error = new Error();
    // error.setDate(new Date());
    // error.setError("El string solo debe de contener numeros enteros");
    // error.setMessage(exception.getMessage());
    // error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    // return ResponseEntity.status(500).body(error);
    // }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> parseIntException(Exception exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", exception.getMessage());
        error.put("date", new Date());
        error.put("error", "El string solo debe de contener numeros enteros");
        error.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

    @ExceptionHandler({
            NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundException.class
    })
    public ResponseEntity<Error> userNotFountException(Exception exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setError("Error,  user or role not found");
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

}
