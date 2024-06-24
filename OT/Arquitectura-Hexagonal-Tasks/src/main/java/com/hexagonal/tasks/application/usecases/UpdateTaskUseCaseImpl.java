package com.hexagonal.tasks.application.usecases;

import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.input.UpdateTaskUseCase;
import com.hexagonal.tasks.domain.ports.output.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Task task) {
        return this.taskRepositoryPort.update(task);
    }

}
