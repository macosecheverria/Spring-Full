package org.example.springcloud.msvc.usuarios.services;

import org.example.springcloud.msvc.usuarios.models.dtos.CreateUserDto;
import org.example.springcloud.msvc.usuarios.models.dtos.UpdateUserDto;
import org.example.springcloud.msvc.usuarios.models.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(CreateUserDto createUserDto);

    User update(Long id, UpdateUserDto updateUserDto);

    void deleteById(Long id);

    List<User> findAllById(Iterable<Long> ids);


}
