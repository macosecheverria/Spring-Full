package com.andres.curso.springboot.app.aop.springbootaop.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService;

@RestController
@RequestMapping("/app")
public class GreetingController {

  @Qualifier("greeting")
  private GreetingService greetingService;

  public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @GetMapping("/greeting")
  public ResponseEntity<Map<String, Object>> greeting() {
    Map<String, Object> json = new HashMap<>();
    json.put("greeting", greetingService.sayHello("Pepe", "Hola que tal"));

    return ResponseEntity.ok(json);

  }

  @GetMapping("/greeting-error")
  public ResponseEntity<Map<String, Object>> greetingError() {
    Map<String, Object> json = new HashMap<>();
    json.put("error", greetingService.sayHelloError("pepe", "algun error"));
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(json);
  }

}
