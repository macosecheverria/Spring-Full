package com.andres.curso.springboot.app.interceptor.springbootinterceptor.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/foo")
    public Map<String, Object> foo() {

        return Collections.singletonMap("message", "Handler foo the controller");
    }

    @GetMapping("/bar")
    public Map<String, Object> bar() {

        return Collections.singletonMap("message", "Handler bar the controller");
    }

    @GetMapping("/baz")
    public Map<String, Object> baz() {

        return Collections.singletonMap("message", "Handler baz the controller");
    }

}
