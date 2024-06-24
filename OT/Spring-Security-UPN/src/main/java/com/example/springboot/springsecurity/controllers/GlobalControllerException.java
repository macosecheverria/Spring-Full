package com.example.springboot.springsecurity.controllers;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.springboot.springsecurity.exception.Error;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error handlerMethodArgumentNotValid(MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();

        return Error.builder()
                .statuscode(400)
                .messageDefault(exception.getMessage())
                .detailsMessage(result.getFieldErrors().
                        stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList())
                )
                .build();

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Error handlerInternalServerError(Exception exception) {
        return Error.builder()
                .statuscode(500)
                .messageDefault(exception.getMessage())
                .detailsMessage(List.of("Internal Server Error"))
                .build();
    }
}


