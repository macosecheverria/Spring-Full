package com.example.authspringsecurity.authspringsecurity.domain.dtos.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterUserDto {

    @NotBlank(message = "The field name is required")
    private String name;

    @NotBlank(message = "The field name is required")
    private String email;

    @NotBlank(message = "The field name is required")
    private String password;

}
