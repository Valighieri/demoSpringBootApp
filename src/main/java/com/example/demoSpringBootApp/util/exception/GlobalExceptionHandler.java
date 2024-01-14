package com.example.demoSpringBootApp.util.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ProblemDetail globalExceptionHandler(Exception ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail entityNotFoundExceptionHandler(EntityNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), ex.getMessage());
    }

    @ExceptionHandler(UserBookLimitException.class)
    public ProblemDetail userBookLimitExceptionHandler(UserBookLimitException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(406), ex.getMessage());
    }
    @ExceptionHandler(UserWithoutThatBookException.class)
    public ProblemDetail userWithoutThatBookExceptionHandler(UserWithoutThatBookException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(406), ex.getMessage());
    }

}
