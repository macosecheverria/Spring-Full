package com.example.authspringsecurity.authspringsecurity.presentacion.services;

import com.example.authspringsecurity.authspringsecurity.data.postgres.models.User;
import com.example.authspringsecurity.authspringsecurity.domain.dtos.auth.LoginUserDto;
import com.example.authspringsecurity.authspringsecurity.domain.dtos.auth.RegisterUserDto;
import com.example.authspringsecurity.authspringsecurity.domain.interfaces.auth.AuthService;
import com.example.authspringsecurity.authspringsecurity.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;


    @Override
    public User registerUser(RegisterUserDto registerUserDto) {
        User newRegisterUser = new User();

        return newRegisterUser;
    }

    @Override
    public User loginUser(LoginUserDto loginUserDto) {
        User newLoginUser = new User();

        return newLoginUser;
    }
}
