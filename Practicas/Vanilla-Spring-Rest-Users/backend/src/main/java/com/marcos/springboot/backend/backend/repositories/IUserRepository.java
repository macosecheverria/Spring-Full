package com.marcos.springboot.backend.backend.repositories;

import java.util.List;

import com.marcos.springboot.backend.backend.models.Users;

public interface IUserRepository {
    List<Users> findAll();
    Users findById(Long id);
}
