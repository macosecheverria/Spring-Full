package com.marcos.spring.fhrestddd.app.fhrestddd.domain.entities;

public class ErrorPersonalized {
    private String errorMessage;
    private int statusCode;

    public ErrorPersonalized() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    

}
