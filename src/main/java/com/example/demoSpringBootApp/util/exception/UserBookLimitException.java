package com.example.demoSpringBootApp.util.exception;

public class UserBookLimitException extends RuntimeException{
    public UserBookLimitException(String message) {
        super(message);
    }
}
