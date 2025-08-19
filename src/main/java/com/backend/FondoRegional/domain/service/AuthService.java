package com.backend.FondoRegional.domain.service;

import com.backend.FondoRegional.domain.dto.LoginRequest;
import com.backend.FondoRegional.domain.dto.TokenResponse;
import com.backend.FondoRegional.persistance.repository.fondoregional.UsuarioRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRespository usuarioRespository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        var user = usuarioRespository.findByCorreo(request.email()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return new TokenResponse(jwtToken);
    }
}
