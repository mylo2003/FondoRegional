package com.backend.FondoRegional.domain.dto;

public record UsuarioResponse(
        String nombre,
        String apellido,
        String correo,
        String rol,
        String fechaModificacion
) {
}
