package com.andres.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springbootweb.models.User;
import com.andres.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valuesList;

    @Value("#{ '${config.listOfValues}'.toUpperCase() } ")
    private String valuesString;

    @Value("#{ ${config.valueMap} }")
    private Map<String, Object> valueMap;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        var param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {

        user.setName(user.getName().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> getAllValues() {
        Map<String, Object> json = new HashMap<>();

        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("list of values", listOfValues);
        json.put("values list", valuesList);
        json.put("values string", valuesString);
        json.put("value map", valueMap);

        return json;
    }

    @GetMapping("/env")
    public Map<String, Object> env() {
        Map<String, Object> json = new HashMap<>();
        json.put("message", environment.getProperty("config.message"));
        json.put("code", environment.getProperty("config.code", Long.class));
        json.put("username", environment.getProperty("config.username"));

        return json;
    }

}
