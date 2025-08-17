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
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "item_id", nullable = false)
    private Integer id;

    @Column(name = "url_pdf", length = 500)
    private String urlPdf;

    @Column(name = "url_portada", length = 500)
    private String urlPortada;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_modificacion")
    private Instant fechaModificacion;

    @ColumnDefault("0")
    @Column(name = "restringido")
    private Boolean restringido;
}
