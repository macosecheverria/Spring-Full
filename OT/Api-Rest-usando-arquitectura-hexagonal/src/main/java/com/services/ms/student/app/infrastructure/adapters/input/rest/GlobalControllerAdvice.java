package com.services.ms.student.app.infrastructure.adapters.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.services.ms.student.app.domain.exception.StudenNotFoundException;
import com.services.ms.student.app.domain.models.ErrorResponse;
import static com.services.ms.student.app.infrastructure.utils.ErrorCatalog.*;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudenNotFoundException.class)
    public ErrorResponse handlerStudenNotFoundException() {
        return ErrorResponse.builder()
                .code(STUDENT_NOT_FOUND.getCode())
                .message(STUDENT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(INVALID_STUDEN.getCode())
                .message(INVALID_STUDEN.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getDefaultMessage()).toList())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handlerGlobalException(Exception exception) {

        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .details(List.of(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

}
