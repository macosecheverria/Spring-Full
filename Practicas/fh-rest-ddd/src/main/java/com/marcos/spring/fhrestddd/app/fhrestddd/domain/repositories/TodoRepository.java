package com.marcos.spring.fhrestddd.app.fhrestddd.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcos.spring.fhrestddd.app.fhrestddd.domain.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
