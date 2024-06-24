package com.hexagonal.tasks.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.tasks.infrastructure.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
    
}
