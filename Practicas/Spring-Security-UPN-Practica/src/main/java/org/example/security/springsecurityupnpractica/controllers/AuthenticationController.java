package org.example.security.springsecurityupnpractica.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.security.springsecurityupnpractica.dtos.AuthCreateUserRequest;
import org.example.security.springsecurityupnpractica.dtos.AuthLoginRequest;
import org.example.security.springsecurityupnpractica.dtos.AuthResponseCreate;
import org.example.security.springsecurityupnpractica.dtos.AuthResponseLogin;
import org.example.security.springsecurityupnpractica.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseCreate> register(
            @Valid @RequestBody AuthCreateUserRequest authCreateUserRequest){
        AuthResponseCreate userCreated = this.userService.createUser(authCreateUserRequest);

        return ResponseEntity.status(201).body(userCreated);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseLogin> login(
            @Valid @RequestBody AuthLoginRequest authLoginRequest
            ){
        AuthResponseLogin userLogin =  this.userService.loginUser(authLoginRequest);

        return ResponseEntity.ok(userLogin);
    }


}
