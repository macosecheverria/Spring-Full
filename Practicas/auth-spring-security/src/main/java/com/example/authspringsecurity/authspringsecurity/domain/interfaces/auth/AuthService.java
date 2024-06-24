package com.example.authspringsecurity.authspringsecurity.domain.interfaces.auth;

import com.example.authspringsecurity.authspringsecurity.data.postgres.models.User;
import com.example.authspringsecurity.authspringsecurity.domain.dtos.auth.LoginUserDto;
import com.example.authspringsecurity.authspringsecurity.domain.dtos.auth.RegisterUserDto;

public interface AuthService {

    User registerUser(RegisterUserDto registerUserDto);

    User loginUser(LoginUserDto loginUserDto);
}
