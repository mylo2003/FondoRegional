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
@Table(name = "biblioitems")
public class Biblioitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "biblioitemnumber", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "volume")
    private String volume;

    @Lob
    @Column(name = "number")
    private String number;

    @Column(name = "itemtype", length = 10)
    private String itemtype;

    @Lob
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publishercode")
    private String publishercode;

    @Column(name = "volumedate")
    private LocalDate volumedate;

    @Lob
    @Column(name = "editionstatement")
    private String editionstatement;

    @Lob
    @Column(name = "editionresponsibility")
    private String editionresponsibility;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @Column(name = "illus")
    private String illus;

    @Column(name = "pages")
    private String pages;

    @Column(name = "size")
    private String size;

    @Column(name = "place")
    private String place;

    @Lob
    @Column(name = "url")
    private String url;

    @Column(name = "cn_source", length = 10)
    private String cnSource;

    //TODO [Reverse Engineering] generate columns from DB
}