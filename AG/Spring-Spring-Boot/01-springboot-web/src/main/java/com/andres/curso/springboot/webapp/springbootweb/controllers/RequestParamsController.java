package com.andres.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.andres.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Sin mensaje") String message) {
        var param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {

        var params = new ParamMixDto();
        params.setText(text);
        params.setCode(code);

        return params;

    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        var params = new ParamMixDto();

        Integer code = 0;

        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            e.getStackTrace();
        }

        params.setText(request.getParameter("text"));
        params.setCode(code);

        return params;
    }

}
