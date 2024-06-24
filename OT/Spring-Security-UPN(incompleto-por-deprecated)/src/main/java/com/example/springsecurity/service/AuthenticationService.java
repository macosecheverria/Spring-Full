package com.example.springsecurity.service;

import com.example.springsecurity.dtos.AuthenticationRequest;
import com.example.springsecurity.dtos.AuthenticationResponse;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authRequest){
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
        );

        authenticationManager.authenticate(authToken);

        User user = this.userRepository.findByUsername(authRequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        String jwt = this.jwtService.generateToken(user,this.generateExtraClaims(user));

        return new AuthenticationResponse(null);
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims =  new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole());

        return extraClaims;
    }

}
