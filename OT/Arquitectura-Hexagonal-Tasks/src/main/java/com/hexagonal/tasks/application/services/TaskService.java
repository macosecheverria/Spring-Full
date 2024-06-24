package com.hexagonal.tasks.application.services;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.input.CreateTaskUseCase;
import com.hexagonal.tasks.domain.ports.input.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.ports.input.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.input.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.ports.input.UpdateTaskUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase; 
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase  getAdditionalTaskInfoUseCase;

    @Override
    public Task createTask(Task task) {
        return this.createTaskUseCase.createTask(task);
    }

    @Override
    public List<Task> getAllTask() {
        return this.retrieveTaskUseCase.getAllTask();
    }

    @Override
    public Optional<Task> getTaskByid(Long id) {
        return this.retrieveTaskUseCase.getTaskByid(id);
    }

    @Override
    public Optional<Task> updateTask( Task task) {

        return this.updateTaskUseCase.updateTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return this.deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long id) {
        return this.getAdditionalTaskInfoUseCase.getAdditionalTasksInfo(id);
    }



}
