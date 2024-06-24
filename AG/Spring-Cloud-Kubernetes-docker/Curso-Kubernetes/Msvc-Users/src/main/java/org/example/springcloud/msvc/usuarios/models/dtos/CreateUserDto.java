package org.example.springcloud.msvc.usuarios.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserDto {
    @NotBlank(message = "The field name is required and cannot be blank")
    @Size(min = 3, message = "Name too short")
    private String name;

    @NotBlank(message = "The field email is required and cannot be blank")
    @Email
    private String email;

    @NotBlank(message = "The field password is required and cannot be blank")
    @Size(min = 6, message = "Password too short")
    private String password;
}
