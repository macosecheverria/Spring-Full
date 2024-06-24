package com.andres.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springbootweb.models.User;
import com.andres.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        var user = new User("Marcos", "Echeverria");

        Map<String, Object> res = new HashMap<>();
        res.put("title", "Hello World from Spring Boot Rest");
        res.put("name", user.getName());
        res.put("lastName", user.getLastName());
        return res;
    }

    @GetMapping("/user-map")
    public Map<String, Object> getUser() {
        var user = new User("Marcos", "Echeverria");

        Map<String, Object> res = new HashMap<>();
        res.put("user", user);
        return res;
    }

    @GetMapping("/user-dto")
    public UserDto getUserDto() {
        var userDto = new UserDto();
        var user = new User("Marcos", "Echeverria");

        userDto.setUser(user);
        userDto.setTitle("Hola munndo Spring");

        return userDto;
    }

    @GetMapping("/list-users")
    public List<User> list(){
        var user = new User("Juan", "Echeverria");
        var user2 = new User("Juana", "Ramirez");
        var user3 = new User("Selva", "Echeverria");

        List<User> users = List.of(user, user2, user3);

        return users;
    }

}
