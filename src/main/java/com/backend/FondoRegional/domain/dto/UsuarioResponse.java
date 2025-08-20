package com.backend.FondoRegional.domain.dto;

public record UsuarioResponse(
        Integer id,
        String nombre,
        String apellido,
        String correo,
        String rol,
        String fechaModificacion
) {
}
