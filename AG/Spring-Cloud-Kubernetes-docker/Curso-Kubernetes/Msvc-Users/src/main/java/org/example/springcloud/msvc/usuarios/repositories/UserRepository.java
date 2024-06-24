package org.example.springcloud.msvc.usuarios.repositories;

import org.example.springcloud.msvc.usuarios.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.email=?1")
    Optional<User> byEmail(String email);

    boolean existsByEmail(String email);
}
