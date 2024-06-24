package org.example.springcloud.msvc.mscvcourses.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseDto {

    @NotBlank(message = "The field name is required and cannot be empty")
    @Size(min = 3)
    private String name;
}
