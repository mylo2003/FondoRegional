package com.backend.FondoRegional.persistance.jpa;

import com.backend.FondoRegional.persistance.entity.VistaFondoRegional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VistaFondoRegionalRepository extends JpaRepository<VistaFondoRegional, Integer>, JpaSpecificationExecutor<VistaFondoRegional> {
}
