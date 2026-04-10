package com.gouveacorp.enhancedtodo;

public class TodoNotExistByIdException extends RuntimeException {
    public TodoNotExistByIdException(String message) {
        super(message);
    }
}
