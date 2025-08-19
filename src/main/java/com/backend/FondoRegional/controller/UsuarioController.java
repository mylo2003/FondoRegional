package com.backend.FondoRegional.controller;

import com.backend.FondoRegional.domain.dto.RegisterRequest;
import com.backend.FondoRegional.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody final RegisterRequest request) {
        try {
            usuarioService.createUser(request);
            return ResponseEntity.ok("Usuario creado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
