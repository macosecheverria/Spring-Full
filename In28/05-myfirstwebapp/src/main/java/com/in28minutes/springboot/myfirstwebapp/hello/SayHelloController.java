package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SayHelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello what are you learning today";
    }

    @GetMapping("/say-hello-html")
    public String helloHtml() {
        return "<h1>Hello what are you learning today</h1>";
    }

    @GetMapping("/say-hello-jsp")
    public String helloJsp() {
        return "sayHello";
    }

}