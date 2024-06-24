package com.example.authspringsecurity.authspringsecurity.domain.repository;

import com.example.authspringsecurity.authspringsecurity.data.postgres.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
