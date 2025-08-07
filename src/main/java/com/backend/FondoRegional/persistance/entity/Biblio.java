package com.backend.FondoRegional.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "biblio")
public class Biblio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "biblionumber", nullable = false)
    private Integer id;

    @ColumnDefault("''")
    @Column(name = "frameworkcode", nullable = false, length = 4)
    private String frameworkcode;

    @Lob
    @Column(name = "author")
    private String author;

    @Lob
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "unititle")
    private String unititle;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Column(name = "copyrightdate")
    private Short copyrightdate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @Column(name = "datecreated", nullable = false)
    private LocalDate datecreated;

    @Lob
    @Column(name = "abstract")
    private String abstractField;

    //TODO [Reverse Engineering] generate columns from DB
}