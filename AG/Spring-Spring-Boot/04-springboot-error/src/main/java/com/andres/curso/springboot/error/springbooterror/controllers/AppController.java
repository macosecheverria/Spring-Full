package com.andres.curso.springboot.error.springbooterror.controllers;

import java.util.List;
//  import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.andres.curso.springboot.error.springbooterror.models.domain.User;
import com.andres.curso.springboot.error.springbooterror.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index() {
        // int value = 100/0;

        int value = Integer.parseInt("10x");
        System.out.println(value);

        return "ok 200";
    }

    @GetMapping("/show")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<User> getId(@PathVariable Long id) {

        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        // Optional<User> userOptional = userService.findById(id);

        // if(!userOptional.isPresent()){
        // return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(null);
        // }

        System.out.println(user.getName());
        return ResponseEntity.status(HttpStatus.OK.value()).body(user);
    }

}
