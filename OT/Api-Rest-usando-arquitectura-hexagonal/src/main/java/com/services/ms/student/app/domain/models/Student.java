package com.services.ms.student.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private  Long id;
    private String firtsname;

    private String lastname;

    private Integer age;

    private String address;


}
