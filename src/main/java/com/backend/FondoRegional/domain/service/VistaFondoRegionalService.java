package com.backend.FondoRegional.domain.service;

import com.backend.FondoRegional.persistance.entity.koha.VistaFondoRegional;
import com.backend.FondoRegional.persistance.repository.koha.VistaFondoRegionalRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class VistaFondoRegionalService {

    private final VistaFondoRegionalRepository repository;

    public VistaFondoRegionalService(VistaFondoRegionalRepository repository) {
        this.repository = repository;
    }

    public Page<VistaFondoRegional> buscar(String search, Pageable pageable) {
        return repository.findAll(
                VistaFondoRegionalSpecs.buscarEnTodo(search),
                pageable
        );
    }

    public Page<VistaFondoRegional> obtenerTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
