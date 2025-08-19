package com.backend.FondoRegional.controller;

import com.backend.FondoRegional.persistance.entity.fondoregional.Estadisticas;
import com.backend.FondoRegional.domain.service.EstadisticasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/estadisticas")
@RequiredArgsConstructor
public class EstadisticasController {
    private final EstadisticasService servicio;

    @GetMapping()
    public Optional<Estadisticas> obtener() {
        return servicio.obtener(1);
    }

    @GetMapping("/vista")
    public void incrementarVistas() {
        servicio.incrementarVistas();
    }

    @GetMapping("/descarga")
    public void incrementarDescargas() {
        servicio.incrementarDescargas();
    }
}
