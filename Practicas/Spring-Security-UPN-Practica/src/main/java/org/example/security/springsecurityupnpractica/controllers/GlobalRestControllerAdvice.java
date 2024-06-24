package org.example.security.springsecurityupnpractica.controllers;

import org.example.security.springsecurityupnpractica.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){

        BindingResult result =  exception.getBindingResult();

        return ErrorResponse.builder()
                .message("Invalid Argument")
                .defaultMessage(exception.getMessage())
                .statusCode(400)
                .listMessages(result
                        .getFieldErrors()
                        .stream()
                        .map(field -> field.getDefaultMessage())
                        .collect(Collectors.toList()))
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handlerGlobalException(Exception exception){
        return ErrorResponse.builder()
                .message("Internal Server Error")
                .defaultMessage(exception.getMessage())
                .statusCode(500)
                .build();
    }
}
