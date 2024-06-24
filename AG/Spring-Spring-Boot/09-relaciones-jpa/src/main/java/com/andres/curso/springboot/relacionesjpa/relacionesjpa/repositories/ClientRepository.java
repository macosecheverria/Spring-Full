package com.andres.curso.springboot.relacionesjpa.relacionesjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.curso.springboot.relacionesjpa.relacionesjpa.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
