package com.marcos.springboot.todorest.springbootfhtodorest.dtos;

import java.util.Map;

public class CreateTodoDto {

    private String text;
    
    private CreateTodoDto(String text){
        this.text =  text;
    }

    public static CreateResult<CreateTodoDto> create(Map<String,Object> prop){
        String text = (String) prop.get("text");

        if(text == null || text.isEmpty()){
            return new CreateResult<>("Text property is required" ,null);
        };

        return new CreateResult<>(null, new CreateTodoDto(text));

    }
}

