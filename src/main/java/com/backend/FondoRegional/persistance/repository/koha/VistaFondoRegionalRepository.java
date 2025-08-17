package com.backend.FondoRegional.persistance.repository.koha;

import com.backend.FondoRegional.persistance.entity.koha.VistaFondoRegional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VistaFondoRegionalRepository extends JpaRepository<VistaFondoRegional, Integer>, JpaSpecificationExecutor<VistaFondoRegional> {
}
