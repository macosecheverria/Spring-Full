package com.marcos.springboot.todorest.springbootfhtodorest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcos.springboot.todorest.springbootfhtodorest.entities.Todo;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, Long> {

    
}