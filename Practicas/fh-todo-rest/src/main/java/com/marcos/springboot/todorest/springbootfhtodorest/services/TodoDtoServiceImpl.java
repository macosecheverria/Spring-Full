package com.marcos.springboot.todorest.springbootfhtodorest.services;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.marcos.springboot.todorest.springbootfhtodorest.entities.Todo;

@Service("todoDtoService")
public class TodoDtoServiceImpl implements TodoService {

    @Override
    public Todo createTodo(Todo todo) {
        throw new UnsupportedOperationException("Unimplemented method 'createTodo'");
    }

    @Override
    public List<Todo> getAllTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllTodos'");
    }

    @Override
    public Todo getTodoById(@NonNull Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getTodoById'");
    }

    @Override
    public Todo updateTodoById(@NonNull Long id, Todo todo) {
        throw new UnsupportedOperationException("Unimplemented method 'updateTodoById'");
    }

    @Override
    public void deleteTodoById(@NonNull Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteTodoById'");
    }
    
}
