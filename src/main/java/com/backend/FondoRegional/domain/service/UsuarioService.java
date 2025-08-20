package com.backend.FondoRegional.domain.service;

import com.backend.FondoRegional.domain.dto.RegisterRequest;
import com.backend.FondoRegional.domain.dto.UsuarioResponse;
import com.backend.FondoRegional.persistance.entity.fondoregional.Usuario;
import com.backend.FondoRegional.persistance.repository.fondoregional.UsuarioRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRespository usuarioRespository;
    private final PasswordEncoder passwordEncoder;

    public List<UsuarioResponse> getAll() {
        List<Usuario> usuarios = usuarioRespository.findAll();

        return usuarios.stream()
                .map(u -> new UsuarioResponse(
                        u.getId(),
                        u.getNombre(),
                        u.getApellido(),
                        u.getCorreo(),
                        u.getRol().toString(),
                        u.getFechaModificacion().toString()
                ))
                .toList();
    }

    public void createUser(RegisterRequest request) {
        var user = Usuario.builder()
                .nombre(request.name())
                .apellido(request.lastName())
                .correo(request.email())
                .contrasena(passwordEncoder.encode(request.password()))
                .rol(Optional.ofNullable(request.role())
                    .filter(r -> !r.isBlank())
                    .orElse("usuario"))
                .fechaModificacion(Instant.now())
                .build();

        usuarioRespository.save(user);
    }

    public void deleteUser(Integer id) {
        usuarioRespository.deleteById(id);
    }
}