package org.example.security.springsecurityupnpractica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test-auth")
public class TestAuthenticationController {

    @GetMapping("/get")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("Test - GET");
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(){
        return ResponseEntity.ok("Test - POST");
    }

    @PutMapping("/put")
    public ResponseEntity<String> put(){
        return ResponseEntity.ok("Test - PUT");
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> remove(){
        return ResponseEntity.ok("Test - DELETE");
    }


}
