package com.andres.curso.springboot.webapp.springbootweb.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.andres.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        var user = new User("marcos", "eheverria");
        user.setEmail("marcostest@gmail.com");

        model.addAttribute("title", "Hello World from Spring Boot!!!");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/users-list")
    public String list(Model model) {
        model.addAttribute("title", "Users List");

        return "users";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/home";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return List.of(
                new User("Juan", "Echeverria", "ramirezloco@hotmail.com"),
                new User("Selva", "Echeverria", "selvi@gmail.com"),
                new User("Juana", "Ramirez", "juanaramirez@gmail.com"),
                new User("Marcos", "Ramirez"));
    }

}
