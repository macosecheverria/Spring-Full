package com.services.ms.student.app.infrastructure.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    STUDENT_NOT_FOUND("ERR_STUDEN_001", "Student not found"),
    INVALID_STUDEN("ERR_STUDEN_002", "Invalid studen Parameter"),
    GENERIC_ERROR("ERROR_GENERIC_001", "Internal Server Error");

    private final String code;
    private final String message;

    ErrorCatalog(String code , String message){
        this.code = code;
        this.message = message;
    }
}
