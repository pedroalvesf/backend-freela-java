package com.clean.api.ServiceApi.domain.service;

import java.time.LocalDateTime;

public record ServiceDetailDTO(
        Long id,
        String title,
        String description,
        Long userId,
        float price,
        LocalDateTime createdAt
) {
    public ServiceDetailDTO(Service service) {
        this(
                service.getId(),
                service.getTitle(),
                service.getDescription(),
                service.getUser().getId(),
                service.getPrice(),
                service.getCreatedAt());
    }
}
