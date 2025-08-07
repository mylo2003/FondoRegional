package com.backend.FondoRegional.web.controller;

import com.backend.FondoRegional.domain.service.VistaFondoRegionalService;
import com.backend.FondoRegional.persistance.entity.VistaFondoRegional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fondo-regional")
public class VistaFondoRegionalController {
    private final VistaFondoRegionalService servicio;

    public VistaFondoRegionalController(VistaFondoRegionalService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<VistaFondoRegional> obtenerVista() {
        return servicio.obtenerTodos();
    }
}
