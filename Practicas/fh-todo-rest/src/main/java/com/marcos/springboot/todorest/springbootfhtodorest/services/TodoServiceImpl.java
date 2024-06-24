package com.marcos.springboot.todorest.springbootfhtodorest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.marcos.springboot.todorest.springbootfhtodorest.entities.Todo;
import com.marcos.springboot.todorest.springbootfhtodorest.repositories.TodoRepository;

@Service("todoService")
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        if (todo == null) {
            return null;
        }
        return this.todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return this.todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(@NonNull Long id) {

        Todo todoId = this.todoRepository.findById(id).orElseThrow();
        return todoId;
    }

    @Override
    public Todo updateTodoById(@NonNull Long id, Todo todo) {
     

        Todo todoId = this.todoRepository.findById(id).orElseThrow();

        todoId.setText(todo.getText());

        return this.todoRepository.save(todoId);
    }

    @Override
    public void deleteTodoById(@NonNull Long id) {
    
            this.todoRepository.deleteById(id);

    }

}
