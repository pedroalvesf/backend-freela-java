package com.clean.api.ServiceApi.domain.service;

import jakarta.validation.constraints.NotBlank;

public record ServiceRegisterDTO(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotBlank
        float price
    ) {

}
