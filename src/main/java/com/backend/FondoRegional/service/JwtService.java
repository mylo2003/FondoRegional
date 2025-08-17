package com.backend.FondoRegional.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.backend.FondoRegional.entity.fondoregional.Usuario;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private String secretKey = "mi_llave_secreta_de_prueba";
    private Long jwtExpiration = 86400L;
    private final Algorithm ALGORITHM;

    public JwtService() {
        this.ALGORITHM = Algorithm.HMAC256(secretKey);
    }

    public String generateToken(final Usuario usuario) {
        return buildToken(usuario, jwtExpiration);
    }

    private String buildToken(final Usuario usuario, final long jwtExpiration) {
        return JWT.create()
                .withSubject(usuario.getCorreo())
                .withClaim("role", usuario.getRol())
                .withClaim("userId", usuario.getId())
                .withIssuer("fondo-regional")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtExpiration))
                .sign(ALGORITHM);
    }
}
