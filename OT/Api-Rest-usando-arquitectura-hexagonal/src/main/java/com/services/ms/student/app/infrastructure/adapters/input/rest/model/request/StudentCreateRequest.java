package com.services.ms.student.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    
    @NotBlank(message = "Field firstname cannot be null or empty")
    private String firstname;

    @NotBlank(message = "Field lastname cannot be null or empty")
    private String lastname;

    @NotNull(message = "Field Age cannot be null")
    @Min(value = 1, message = "Fiel Age cannot be greather o equal a 1")
    private Integer age;

    @NotBlank(message = "Field Address cannot be null or empty")
    private String address;
}
