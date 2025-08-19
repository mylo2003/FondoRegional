package com.backend.FondoRegional.domain.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.backend.FondoRegional.persistance.entity.fondoregional.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("${security.jwt.expiration}")
    private Long jwtExpiration;

    private final Algorithm ALGORITHM;

    public JwtService(@Value("${security.jwt.secret}") String secretKey) {
        if (secretKey == null || secretKey.isEmpty()) {
            throw new IllegalStateException("JWT secret key is missing");
        }
        this.ALGORITHM = Algorithm.HMAC256(secretKey);
    }

    public String generateToken(final Usuario usuario) {
        return buildToken(usuario, jwtExpiration);
    }

    private String buildToken(final Usuario usuario, final long jwtExpiration) {
        return JWT.create()
                .withSubject(usuario.getCorreo())
                .withClaim("role", usuario.getRol())
                .withIssuer("fondo-regional")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtExpiration))
                .sign(ALGORITHM);
    }

    public String extractUsername(String token) {
        return JWT.decode(token).getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return JWT.decode(token).getExpiresAt().before(new Date());
    }
}
