package com.marcos.spring.fhrestddd.app.fhrestddd.domain.interfaces;

import java.util.List;

import org.springframework.lang.NonNull;

import com.marcos.spring.fhrestddd.app.fhrestddd.domain.dtos.CreateTodoDto;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.dtos.UpdateTodoDto;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.entities.Todo;

public interface TodoService {
    Todo create(CreateTodoDto createTododDto);

    List<Todo> findAll();

    Todo findById(@NonNull Long id);

    Todo update(@NonNull Long id, UpdateTodoDto updateTodoDto);

    Todo remove(@NonNull Long id);

}
