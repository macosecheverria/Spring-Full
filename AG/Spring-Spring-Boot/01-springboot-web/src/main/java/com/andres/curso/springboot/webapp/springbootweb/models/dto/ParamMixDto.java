package com.andres.curso.springboot.webapp.springbootweb.models.dto;


public class ParamMixDto {
    private String text;
    private Integer code;

    public String getMessage() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
