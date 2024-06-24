package com.example.springboot.springsecurity.persistence.repositories;

import com.example.springboot.springsecurity.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);

    //@Query("select u from UserEntity u where u.username = ?")
    //Optional<UserEntity> findUser(String username);
}
