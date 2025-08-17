package com.backend.FondoRegional.domain.dto;

public record LoginRequest(
        String email,
        String password
) {
}
