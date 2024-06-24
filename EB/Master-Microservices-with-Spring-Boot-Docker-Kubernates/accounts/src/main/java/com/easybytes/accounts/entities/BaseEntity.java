package com.easybytes.accounts.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_at", updatable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", updatable = false)
    private String updatedBy;
}
