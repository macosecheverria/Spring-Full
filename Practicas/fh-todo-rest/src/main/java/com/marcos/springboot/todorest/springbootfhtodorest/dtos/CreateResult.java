package com.marcos.springboot.todorest.springbootfhtodorest.dtos;

public class CreateResult<T> {
    private final String error;
    private final T result;

    public CreateResult(String error, T result) {
        this.error = error;
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public T getResult() {
        return result;
    }

}
