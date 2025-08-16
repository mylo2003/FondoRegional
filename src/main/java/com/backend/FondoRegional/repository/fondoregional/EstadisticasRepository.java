package com.backend.FondoRegional.repository.fondoregional;

import com.backend.FondoRegional.entity.fondoregional.Estadisticas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasRepository extends JpaRepository<Estadisticas, Integer> {
    @Modifying
    @Query("UPDATE Estadisticas e SET e.vistas = e.vistas + 1 WHERE e.id = 1")
    void incrementarVistasQuery();

    @Modifying
    @Query("UPDATE Estadisticas e SET e.descargas = e.descargas + 1 WHERE e.id = 1")
    void incrementarDescargasQuery();
}
