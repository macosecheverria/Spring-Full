package com.in28minutes.springboot.myfirstwebapp.todos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodosService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "marcos",
                "Learn Full Stack Development", LocalDate.now(), false));
        todos.add(new Todo(1, "marcos",
                "Learn Full Stack Development", LocalDate.now(), false));
        todos.add(new Todo(1, "marcos",
                "Learn Full Stack Development", LocalDate.now(), false));
    }

    public List<Todo> findByUsername(String username) {

        return todos;
    }

}
