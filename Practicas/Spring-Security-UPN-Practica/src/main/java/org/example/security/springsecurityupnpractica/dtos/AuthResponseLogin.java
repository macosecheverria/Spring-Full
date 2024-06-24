package org.example.security.springsecurityupnpractica.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;

@JsonPropertyOrder({"username, jwt"})
public record AuthResponseLogin(String username, String jwt) {
}
