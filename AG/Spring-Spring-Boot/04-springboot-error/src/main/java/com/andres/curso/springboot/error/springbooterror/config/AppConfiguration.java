package com.andres.curso.springboot.error.springbooterror.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.andres.curso.springboot.error.springbooterror.models.domain.User;

@Configuration
public class AppConfiguration {

    @Bean("totalUsers")
    List<User> totalUsers() {
        List<User> users = List.of(
                new User(1L, "Marcos", "Echeverria"),
                new User(2L, "Maria", "Echeverria"),
                new User(3L, "Juan", "Echeverria"),
                new User(4L, "Juana", "Echeverria"),
                new User(5L, "Antonio", "Echeverria"));

        return users;
    }

}
