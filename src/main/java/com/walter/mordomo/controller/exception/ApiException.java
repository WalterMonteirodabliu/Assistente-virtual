package com.walter.mordomo.controller.exception;

public class ApiException extends RuntimeException {

    private String message;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
