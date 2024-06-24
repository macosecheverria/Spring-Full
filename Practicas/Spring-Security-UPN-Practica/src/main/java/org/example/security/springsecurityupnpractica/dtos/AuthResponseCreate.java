package org.example.security.springsecurityupnpractica.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "message", "status"})
public record AuthResponseCreate(String username, String message, boolean status)  {
}
