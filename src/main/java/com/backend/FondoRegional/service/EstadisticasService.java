package com.backend.FondoRegional.service;

import com.backend.FondoRegional.entity.fondoregional.Estadisticas;
import com.backend.FondoRegional.repository.fondoregional.EstadisticasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EstadisticasService {
    private final EstadisticasRepository repository;

    public EstadisticasService(EstadisticasRepository repository) {
        this.repository = repository;
    }

    public Optional<Estadisticas> obtener(int i) {
        return repository.findById(1);
    }

    @Transactional("fondoregionalTransactionManager")
    public void incrementarVistas() {
        repository.incrementarVistasQuery();
    }

    @Transactional("fondoregionalTransactionManager")
    public void incrementarDescargas() {
        repository.incrementarDescargasQuery();
    }
}
