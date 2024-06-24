package com.example.springsecurity.controllers;

import com.example.springsecurity.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springsecurity.dtos.AuthenticationRequest;
import com.example.springsecurity.dtos.AuthenticationResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Valid AuthenticationRequest authenticationRequest) {

        AuthenticationResponse jwtDto = authenticationService.login(authenticationRequest);

        return ResponseEntity.ok(jwtDto);
    }

    @GetMapping("/public-access")
    public ResponseEntity<String> publicAccessEndpoint(){
        return ResponseEntity.ok("<h1>Este endpoint es publico</h1>");
    }
}
