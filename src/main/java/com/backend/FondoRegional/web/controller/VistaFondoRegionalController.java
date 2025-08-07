package com.backend.FondoRegional.web.controller;

import com.backend.FondoRegional.domain.service.VistaFondoRegionalService;
import com.backend.FondoRegional.persistance.entity.VistaFondoRegional;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/fondo-regional")
public class VistaFondoRegionalController {
    private final VistaFondoRegionalService servicio;

    public VistaFondoRegionalController(VistaFondoRegionalService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public Page<VistaFondoRegional> obtenerVista(Pageable pageable) {
        return servicio.obtenerTodos(pageable);
    }
}
