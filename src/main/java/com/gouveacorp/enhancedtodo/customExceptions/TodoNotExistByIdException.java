package com.gouveacorp.enhancedtodo.customExceptions;

public class TodoNotExistByIdException extends RuntimeException {
    public TodoNotExistByIdException(String message) {
        super(message);
    }
}
