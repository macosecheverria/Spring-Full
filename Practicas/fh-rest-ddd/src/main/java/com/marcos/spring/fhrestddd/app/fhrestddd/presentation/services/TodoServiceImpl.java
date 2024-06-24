package com.marcos.spring.fhrestddd.app.fhrestddd.presentation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcos.spring.fhrestddd.app.fhrestddd.domain.dtos.CreateTodoDto;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.dtos.UpdateTodoDto;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.entities.Todo;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.interfaces.TodoService;
import com.marcos.spring.fhrestddd.app.fhrestddd.domain.repositories.TodoRepository;

@Service("todoService")
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    @Transactional
    public Todo create(CreateTodoDto createTododDto) {
        Todo todo = new Todo();

        todo.setText(createTododDto.getText());

        return this.todoRepository.save(todo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        return this.todoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Todo findById(@NonNull Long id) {
        Optional<Todo> todoId = this.todoRepository.findById(id);

        return todoId.get();
    }

    @Override
    @Transactional
    public Todo update(@NonNull Long id, UpdateTodoDto updateTodoDto) {
        Todo todoId = this.findById(id);

        todoId.setText(updateTodoDto.getText());

        this.todoRepository.save(todoId);

        return todoId;
    }

    @Override
    @Transactional
    public Todo remove(@NonNull Long id) {
        Todo todoId = this.findById(id);

        this.todoRepository.deleteById(id);

        return todoId;
    }

}
