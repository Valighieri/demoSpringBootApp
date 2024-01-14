package com.example.demoSpringBootApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        @NotNull
        @Schema(description = "The title of the book.", example = "The Divine Comedy",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String title
) {
    public BookDto(String title) {
        this.title = title;
    }
}
