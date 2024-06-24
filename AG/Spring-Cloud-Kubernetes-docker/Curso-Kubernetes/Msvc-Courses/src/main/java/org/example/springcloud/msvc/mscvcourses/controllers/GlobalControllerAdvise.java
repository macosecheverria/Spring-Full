package org.example.springcloud.msvc.mscvcourses.controllers;

import feign.FeignException;
import org.example.springcloud.msvc.mscvcourses.exception.CourseNotFoundException;
import org.example.springcloud.msvc.mscvcourses.models.dtos.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvise {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CourseNotFoundException.class)
    public ErrorResponse handlerCourseNotFoundException(CourseNotFoundException exception){
        return  ErrorResponse.builder()
                .message(exception.getMessage())
                .statusCode(404)
                .build();
    }

    @ResponseStatus()
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .statusCode(400)
                .messageDetails(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FeignException.class)
    public ErrorResponse handlerFeignException(FeignException exception){
        return ErrorResponse.builder()
                .statusCode(500)
                .message(exception.getMessage())
                .messageDetails(
                        List.of("The user could not be created or there" +
                                " was an error in the microservice communication"))
                .build();
    }
}
