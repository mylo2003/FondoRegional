package com.backend.FondoRegional.controller;

import com.backend.FondoRegional.service.VistaFondoRegionalService;
import com.backend.FondoRegional.entity.koha.VistaFondoRegional;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@CrossOrigin("*")
@RequestMapping("/fondo-regional")
public class VistaFondoRegionalController {
    private final VistaFondoRegionalService servicio;

    public VistaFondoRegionalController(VistaFondoRegionalService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/libros")
    public Page<VistaFondoRegional> obtenerVista(Pageable pageable) {
        return servicio.obtenerTodos(pageable);
    }

    @GetMapping("/libros/filtro")
    public Page<VistaFondoRegional> buscar(
            @RequestParam(required = false) String search,
            Pageable pageable
    ) {
        return servicio.buscar(search, pageable);
    }
}
