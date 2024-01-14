package com.example.demoSpringBootApp.util.exception;

public class UserWithoutThatBookException extends RuntimeException{
    public UserWithoutThatBookException(String message) {
        super(message);
    }
}
