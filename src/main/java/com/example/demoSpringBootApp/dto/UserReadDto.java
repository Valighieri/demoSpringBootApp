package com.example.demoSpringBootApp.dto;

import com.example.demoSpringBootApp.domain.Book;

import java.util.Set;

public record UserReadDto(
        String name,
        String email,
        Set<BookReadDto> books
) {
    public UserReadDto(String name, String email, Set<BookReadDto> books) {
        this.name = name;
        this.email = email;
        this.books = books;
    }
}
