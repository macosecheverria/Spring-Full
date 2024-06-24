package com.hexagonal.tasks.domain.models;

import java.time.LocalDateTime;

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
public class Task {
    
    private Long id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private boolean completed;
}
