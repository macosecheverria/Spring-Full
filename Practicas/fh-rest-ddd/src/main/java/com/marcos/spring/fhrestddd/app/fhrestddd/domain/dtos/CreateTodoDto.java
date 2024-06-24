package com.marcos.spring.fhrestddd.app.fhrestddd.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public class CreateTodoDto {

    @NotBlank(message = "no debe estar vacio o ser nulo")
    private String text;

    public CreateTodoDto() {
    }

    public CreateTodoDto(@NotBlank(message = "no debe debe de estar vacio o nulo") String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    } 
}
