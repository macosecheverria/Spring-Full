package com.marcos.spring.fhrestddd.app.fhrestddd.presentation.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.spring.fhrestddd.app.fhrestddd.domain.dtos.CreateTodoDto;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.dtos.UpdateTodoDto;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.entities.Todo;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.errors.NotFoundException;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.interfaces.TodoService;
import com.marcos.spring.fhrestddd.app.fhrestddd.helpers.BindingValidation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Qualifier("todoService")
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@Valid @RequestBody CreateTodoDto createTodoDto, BindingResult result) {

        if (result.hasFieldErrors()) {
            return BindingValidation.validation(result);
        }

        Todo todoCreated = this.todoService.create(createTodoDto);

        return ResponseEntity.status(200).body(todoCreated);
    }

    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        List<Todo> todo = this.todoService.findAll();

        return ResponseEntity.status(200).body(todo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable @NonNull Long id) throws NotFoundException {

        try {
            Todo todo = this.todoService.findById(id);

            return ResponseEntity.status(200).body(todo);

        } catch (NotFoundException e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@Valid @RequestBody UpdateTodoDto updateTodoDto, BindingResult result,
            @PathVariable @NonNull Long id) {
                
        if (result.hasFieldErrors()) {
            return BindingValidation.validation(result);
        }

        Todo todoUpdated = this.todoService.update(id, updateTodoDto);

        return ResponseEntity.status(200).body(todoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable @NonNull Long id) {
        Todo todoDeleted = this.todoService.remove(id);

        return ResponseEntity.status(200).body(todoDeleted);
    }

}
