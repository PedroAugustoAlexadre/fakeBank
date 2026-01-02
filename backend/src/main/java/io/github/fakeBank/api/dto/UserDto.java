package io.github.fakeBank.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank
        String name,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String document) {}
