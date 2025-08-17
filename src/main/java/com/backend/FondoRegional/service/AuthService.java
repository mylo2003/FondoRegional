package com.backend.FondoRegional.service;

import com.backend.FondoRegional.dto.RegisterRequest;
import com.backend.FondoRegional.dto.TokenResponse;
import com.backend.FondoRegional.entity.fondoregional.Usuario;
import com.backend.FondoRegional.repository.fondoregional.UsuarioRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRespository usuarioRespository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public TokenResponse register(RegisterRequest request) {
        var user = Usuario.builder()
                .nombre(request.name())
                .apellido(request.lastName())
                .correo(request.email())
                .contrasena(passwordEncoder.encode(request.password()))
                .rol(request.role())
                .build();

        usuarioRespository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return new TokenResponse(jwtToken);
    }
}
