package org.example.security.springsecurityupnpractica.dtos;

import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record AuthCreateRoleRequest(
        @Size(max = 3, message = "The field roleList cannot have than 3 roles") List<String> roleList
) {
}
