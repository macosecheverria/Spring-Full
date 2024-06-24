package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.input.CreateTaskUseCase;
import com.hexagonal.tasks.domain.ports.output.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase{

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return this.taskRepositoryPort.save(task);
    }

    
    
}
