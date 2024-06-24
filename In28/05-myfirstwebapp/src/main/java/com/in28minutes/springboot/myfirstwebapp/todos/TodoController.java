package com.in28minutes.springboot.myfirstwebapp.todos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodosService todosService;

    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todosService.findByUsername("marcos");

        model.addAttribute("todos",todos );
        
        return "listTodos";
    }
    
}
