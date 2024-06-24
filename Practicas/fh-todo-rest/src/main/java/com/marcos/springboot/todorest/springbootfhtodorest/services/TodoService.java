package com.marcos.springboot.todorest.springbootfhtodorest.services;

import java.util.List;

import org.springframework.lang.NonNull;

import com.marcos.springboot.todorest.springbootfhtodorest.entities.Todo;

public interface TodoService {
    Todo createTodo(Todo todo);

    List<Todo> getAllTodos();

    Todo getTodoById(@NonNull Long id);

    Todo  updateTodoById(@NonNull Long id, Todo todo);

    void deleteTodoById(@NonNull Long id);

}
