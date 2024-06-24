package com.services.ms.student.app.infrastructure.adapters.input.rest.model.response;

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
public class StudentResponse {
    
    private Long id;

    private String firstname;

    private String lastname;

    private Integer age;

    private String address;

    
}
