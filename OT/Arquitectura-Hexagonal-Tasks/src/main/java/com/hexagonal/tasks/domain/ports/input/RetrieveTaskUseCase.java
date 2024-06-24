package com.hexagonal.tasks.domain.ports.input;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;

public interface RetrieveTaskUseCase {
    Optional<Task> getTaskByid(Long id);

    List<Task> getAllTask();
}
