package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.ports.input.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.ports.output.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public boolean deleteTask(Long id) {
        return this.taskRepositoryPort.deleteById(id);
    }

}
