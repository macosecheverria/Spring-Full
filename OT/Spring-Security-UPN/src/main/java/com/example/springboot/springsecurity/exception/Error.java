package com.example.springboot.springsecurity.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Error {

    private Integer statuscode;

    private String messageDefault;

    private List<String> detailsMessage;
}