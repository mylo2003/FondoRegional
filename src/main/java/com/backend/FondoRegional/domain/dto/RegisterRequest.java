package com.backend.FondoRegional.domain.dto;

public record RegisterRequest(
        String email,
        String password,
        String name,
        String lastName,
        String role
) {
}
