package com.hexagonal.tasks.infrastructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.domain.models.Task;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task){
        Task newTask = this.taskService.createTask(task);

        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        List<Task> allTask = this.taskService.getAllTask();

        return ResponseEntity.ok(allTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id){
        Task taskId = this.taskService.getTaskByid(id).get();

        return ResponseEntity.ok(taskId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
        Task updateTask = this.taskService.updateTask(task).get();
        
        return ResponseEntity.ok(updateTask);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.taskService.deleteTask(id);
        return ResponseEntity.ok("Task Deleted");
    }
     
}
