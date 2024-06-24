package com.andres.springboot.app.springbootcrud.presentacion.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.app.springbootcrud.domain.entities.User;
import com.andres.springboot.app.springbootcrud.domain.interfaces.UserService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Qualifier("userService")
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody User user, BindingResult result) {

        if(result.hasFieldErrors()){
            return this.validation(result);
        }

        User userCreated = this.userService.save(user);

        return ResponseEntity.status(201).body(userCreated);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user, BindingResult result){
        if(result.hasFieldErrors()){
            return this.validation(result);
        }

        user.setAdmin(false);

        return this.create(user, result);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> allUsers = this.userService.findAll();

        return ResponseEntity.status(200).body(allUsers);
    }


    private ResponseEntity<?> validation(BindingResult result ){
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField()  + " " + err.getDefaultMessage());
        });

        return ResponseEntity.status(400).body(errors);
    }
}
