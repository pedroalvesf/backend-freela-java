package com.clean.api.ServiceApi.domain.service;

import jakarta.validation.constraints.NotNull;

public record ServiceUpdateDTO(
        @NotNull
        Long id,
        String title,
        String description,
        float price
) {}
