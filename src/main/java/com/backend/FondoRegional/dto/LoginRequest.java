package com.backend.FondoRegional.dto;

public record LoginRequest(
        String email,
        String password
) {
}
