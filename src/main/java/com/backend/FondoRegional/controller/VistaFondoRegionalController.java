package com.backend.FondoRegional.controller;

import com.backend.FondoRegional.domain.service.VistaFondoRegionalService;
import com.backend.FondoRegional.persistance.entity.koha.VistaFondoRegional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
public class VistaFondoRegionalController {
    private final VistaFondoRegionalService servicio;

    @GetMapping
    public Page<VistaFondoRegional> obtenerVista(Pageable pageable) {
        return servicio.obtenerTodos(pageable);
    }

    @GetMapping("/filtro")
    public Page<VistaFondoRegional> buscar(
            @RequestParam(required = false) String search,
            Pageable pageable
    ) {
        return servicio.buscar(search, pageable);
    }
}
