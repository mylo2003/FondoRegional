package com.backend.FondoRegional.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "biblio_framework")
public class Framework {
    @Id
    @ColumnDefault("''")
    @Column(name = "frameworkcode", nullable = false, length = 4)
    private String frameworkcode;

    @ColumnDefault("''")
    @Column(name = "frameworktext", nullable = false)
    private String frameworktext;

}
