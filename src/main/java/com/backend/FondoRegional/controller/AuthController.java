package com.backend.FondoRegional.controller;

import com.backend.FondoRegional.domain.dto.RegisterRequest;
import com.backend.FondoRegional.domain.dto.TokenResponse;
import com.backend.FondoRegional.domain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody final RegisterRequest request) {
        final TokenResponse token = service.register(request);

        return ResponseEntity.ok(token);
    }

//    @PostMapping("/login")
//    public ResponseEntity<TokenResponse> login(@RequestBody final LoginRequest request) {
//        final TokenResponse token = service.login(request);
//
//        return ResponseEntity.ok(token);
//    }
}
