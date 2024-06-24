package com.marcos.spring.fhrestddd.app.fhrestddd.presentation.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.marcos.spring.fhrestddd.app.fhrestddd.domain.entities.ErrorPersonalized;

@RestControllerAdvice
public class TodoExceptionController {
    
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> notFound(Exception exception){
        ErrorPersonalized error = new ErrorPersonalized();

        error.setErrorMessage(exception.getMessage());
        error.setStatusCode(404);

        return ResponseEntity.status(404).body(error);
    }
}
