package com.backend.FondoRegional.persistance.entity.fondoregional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estadisticas")
public class Estadisticas {
    @Id
    @ColumnDefault("1")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "vistas")
    private Integer vistas;

    @ColumnDefault("0")
    @Column(name = "descargas")
    private Integer descargas;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "ultima_actualizacion")
    private Instant ultimaActualizacion;
}
