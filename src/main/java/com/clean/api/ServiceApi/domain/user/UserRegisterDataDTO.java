package com.clean.api.ServiceApi.domain.user;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UserRegisterDataDTO(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String email,
        @NotBlank
        String name,

        UserRole role,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
