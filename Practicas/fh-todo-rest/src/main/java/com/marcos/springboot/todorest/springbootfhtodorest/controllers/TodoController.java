package com.marcos.springboot.todorest.springbootfhtodorest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.springboot.todorest.springbootfhtodorest.entities.Todo;
import com.marcos.springboot.todorest.springbootfhtodorest.services.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    @Qualifier("todoService")
    private TodoService service;

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo todoCreated = this.service.createTodo(todo);

        return ResponseEntity.status(200).body(todoCreated);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> allTodos = this.service.getAllTodos();
        return ResponseEntity.status(200).body(allTodos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(
            @PathVariable @NonNull Long id) {
        Todo todo = this.service.getTodoById(id);
        
        if(todo == null){
            return ResponseEntity.status(404).body(null);
        }

        return ResponseEntity.status(200).body(todo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable @NonNull Long id, @RequestBody Todo todo){
        Todo updatedTodo = this.service.updateTodoById(id, todo);

        return ResponseEntity.status(200).body(updatedTodo);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @NonNull Long id ){
        this.service.deleteTodoById(id);
        return ResponseEntity.status(200).body(null);
    }

}
