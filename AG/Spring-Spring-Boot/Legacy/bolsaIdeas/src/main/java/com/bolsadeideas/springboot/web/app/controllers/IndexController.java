package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@RestController
@RequestMapping("/app")
public class IndexController {

    @GetMapping({ "/index", "/", "","/home" })
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model){
        var usuario = new Usuario();
        usuario.setNombre("Marcos");
        usuario.setApellido("Echeverria");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario".concat(usuario.getNombre()));
        return "perfil";
    }
}
