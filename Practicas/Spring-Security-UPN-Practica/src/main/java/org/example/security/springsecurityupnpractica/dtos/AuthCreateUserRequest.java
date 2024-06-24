package org.example.security.springsecurityupnpractica.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUserRequest(
        @NotBlank(message = "The field username is required") String username,
        @NotBlank(message = "The field password is required") String password,
        @Valid  AuthCreateRoleRequest roleRequest
) {
}
