package com.example.springboot.springsecurity.controllers;

import com.example.springboot.springsecurity.controllers.Dtos.AuthCreateUserRequest;
import com.example.springboot.springsecurity.controllers.Dtos.AuthLoginRequest;
import com.example.springboot.springsecurity.controllers.Dtos.AuthResponse;
import com.example.springboot.springsecurity.services.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody AuthCreateUserRequest authCreateUserRequest) {
        AuthResponse newUser = this.userDetailService.createUser(authCreateUserRequest);

        return ResponseEntity.status(201).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthLoginRequest userRequest) {

        return ResponseEntity.status(201).body(this.userDetailService.loginUser(userRequest));
    }
}
