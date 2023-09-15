package com.clean.api.ServiceApi.domain.user;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDataDTO(
        @NotNull
        Long id,
        String username,
        String email,
        String name
) {}
