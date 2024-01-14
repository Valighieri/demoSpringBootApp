package com.example.demoSpringBootApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(

        @NotNull
        @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
        @Schema(description = "Name of an employee.", example = "Marly",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String name,

        @NotNull
        @Schema(description = "Email address.", example = "marly@gmail.com",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String email
) {
    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
