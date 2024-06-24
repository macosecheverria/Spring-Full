package com.andres.curso.backendproduct.backendproducts.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.andres.curso.backendproduct.backendproducts.dtos.ErrorResponse;
import com.andres.curso.backendproduct.backendproducts.exceptions.ProductNotFoundExceptions;

@RestControllerAdvice
public class GlobalControllerAbvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundExceptions.class)
    public ErrorResponse handlerProductNotFoundError() {
        return ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("The product not found")
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgsNotValid(MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage())
                .detailMessage(
                        result.getFieldErrors().stream().map(fielError -> fielError.getDefaultMessage()).toList())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerError.class)
    public ErrorResponse handlerInternalServerError(Exception exception) {
        return ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

}