package org.example.springcloud.msvc.usuarios.controllers;

import org.example.springcloud.msvc.usuarios.exceptions.EmailAlreadyExistException;
import org.example.springcloud.msvc.usuarios.exceptions.UserNotFoundException;
import org.example.springcloud.msvc.usuarios.models.dtos.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handlerUserNotFoundException(UserNotFoundException exception){
        return ErrorResponse.builder()
                .statusCode(404)
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ErrorResponse handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .message(exception.getMessage())
                .statusCode(400)
                .detailsMesssage(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ErrorResponse handlerEmailAlreadyExistException(Exception exception){
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .statusCode(400)
                .build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ErrorResponse handlerMissingServletRequestParameterException(
            MissingServletRequestParameterException exception){
        return  ErrorResponse.builder()
                .message(exception.getMessage())
                .statusCode(400)
                .build();
    }
}
