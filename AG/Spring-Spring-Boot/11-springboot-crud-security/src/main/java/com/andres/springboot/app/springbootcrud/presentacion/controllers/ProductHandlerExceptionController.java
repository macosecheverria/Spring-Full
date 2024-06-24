package com.andres.springboot.app.springbootcrud.presentacion.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.andres.springboot.app.springbootcrud.domain.entities.Error;

@RestControllerAdvice(basePackageClasses = ProductController.class)
public class ProductHandlerExceptionController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> notFound(Exception exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setError("Product id not found");
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> argumentTypeMismatch(Exception exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setError("Type the data is invalid, the data  type must be a number");
        error.setStatus(400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValid(Exception exception){
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setError("Required Camps");
        error.setStatus(400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<?> internalServerError(Exception exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setError("Internal server Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }
}