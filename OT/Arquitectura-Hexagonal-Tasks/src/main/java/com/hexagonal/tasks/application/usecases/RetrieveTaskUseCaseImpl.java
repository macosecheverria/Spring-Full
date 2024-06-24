package com.hexagonal.tasks.application.usecases;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.input.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.ports.output.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public List<Task> getAllTask() {
        return this.taskRepositoryPort.findAll();
    }

    @Override
    public Optional<Task> getTaskByid(Long id) {
        return this.taskRepositoryPort.findById(id);
    }

}
