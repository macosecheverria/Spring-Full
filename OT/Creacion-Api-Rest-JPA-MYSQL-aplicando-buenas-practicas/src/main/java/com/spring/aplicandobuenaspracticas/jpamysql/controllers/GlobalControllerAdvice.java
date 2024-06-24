package com.spring.aplicandobuenaspracticas.jpamysql.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.aplicandobuenaspracticas.jpamysql.exceptions.CategoryNotFoundException;
import com.spring.aplicandobuenaspracticas.jpamysql.exceptions.ProductNotFoundException;
import com.spring.aplicandobuenaspracticas.jpamysql.models.dtos.ErrorResponse;

import static com.spring.aplicandobuenaspracticas.jpamysql.utils.ErrorCatalog.*;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handlerProductNotFoundError() {
        return ErrorResponse.builder()
                .code(PRODUCT_NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND)
                .message(PRODUCT_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorResponse handlerCategoryNotFound() {
        return ErrorResponse.builder()
                .code(CATEGORY_NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND)
                .message(CATEGORY_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(INVALID_PRODUCT.getCode())
                .status(HttpStatus.BAD_REQUEST)
                .message(INVALID_PRODUCT.getMessage())
                .detailMessage(result.getFieldErrors()
                    .stream()
                    .map(fieltError -> fieltError.getDefaultMessage())
                    .toList())
                .timeStamp(LocalDateTime.now())
                .build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handlerInternalServerError(Exception exception){
        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(GENERIC_ERROR.getMessage())
                .detailMessage(List.of(exception.getMessage()))
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
