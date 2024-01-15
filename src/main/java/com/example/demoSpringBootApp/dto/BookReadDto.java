package com.example.demoSpringBootApp.dto;


import com.example.demoSpringBootApp.domain.User;

public record BookReadDto(
        String title

) {
    public BookReadDto(String title) {
        this.title = title;
    }
}
