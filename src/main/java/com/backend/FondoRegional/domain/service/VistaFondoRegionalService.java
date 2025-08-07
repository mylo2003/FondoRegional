package com.backend.FondoRegional.domain.service;

import com.backend.FondoRegional.persistance.entity.VistaFondoRegional;
import com.backend.FondoRegional.persistance.jpa.VistaFondoRegionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VistaFondoRegionalService {

    private final VistaFondoRegionalRepository repository;

    public VistaFondoRegionalService(VistaFondoRegionalRepository repository) {
        this.repository = repository;
    }

    public List<VistaFondoRegional> obtenerTodos() {
        return repository.findAll();
    }
}
