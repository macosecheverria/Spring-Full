package com.andres.springboot.app.springbootcrud.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.springboot.app.springbootcrud.domain.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
     Optional<Role> findByName(String name);
}
