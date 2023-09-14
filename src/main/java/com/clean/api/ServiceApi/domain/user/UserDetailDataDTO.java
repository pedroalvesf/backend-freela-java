package com.clean.api.ServiceApi.domain.user;

import java.time.LocalDateTime;

public record UserDetailDataDTO (        Long id,
        String username,
        String email,
        String name,
        UserRole role,

        Boolean active,

        LocalDateTime createdAt) {
    public UserDetailDataDTO(User user) {
        this(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getName(),
                user.getRole(),
                user.getActive(),
                user.getCreatedAt());
    }
}
