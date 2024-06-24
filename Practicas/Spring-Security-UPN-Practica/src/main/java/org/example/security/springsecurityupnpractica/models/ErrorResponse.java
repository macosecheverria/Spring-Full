package org.example.security.springsecurityupnpractica.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;

    private String defaultMessage;

    private Integer statusCode;

    private List<String> listMessages;
}
