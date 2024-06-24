package com.hexagonal.tasks.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.output.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.entities.TaskEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity saveTask = this.taskRepository.save(taskEntity);

        return saveTask.toDomainModel();
    }

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.taskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public Optional<Task> update(Task task) {
        if (!this.taskRepository.existsById(task.getId())) {
            return Optional.empty();
        }

        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity updateTask = this.taskRepository.save(taskEntity);

        return Optional.of(updateTask.toDomainModel());
    }

    @Override
    public boolean deleteById(Long id) {
        if (!this.taskRepository.existsById(id)) {
            return false;
        }

        this.taskRepository.deleteById(id);
        return true;
    }

}
