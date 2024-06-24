package com.andres.springboot.app.springbootcrud.domain.interfaces;

import java.util.List;

import com.andres.springboot.app.springbootcrud.domain.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}
