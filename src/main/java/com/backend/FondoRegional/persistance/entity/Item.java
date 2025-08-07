package com.backend.FondoRegional.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemnumber", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("0")
    @JoinColumn(name = "biblionumber", nullable = false)
    private Biblio biblionumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("0")
    @JoinColumn(name = "biblioitemnumber", nullable = false)
    private Biblioitem biblioitemnumber;

    @Column(name = "barcode", length = 20)
    private String barcode;

    @Column(name = "dateaccessioned")
    private LocalDate dateaccessioned;

    @Lob
    @Column(name = "booksellerid")
    private String booksellerid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homebranch")
    private Branch homebranch;

    @Column(name = "price", precision = 8, scale = 2)
    private BigDecimal price;

    @Column(name = "datelastseen")
    private LocalDate datelastseen;

    @Column(name = "itemcallnumber")
    private String itemcallnumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "holdingbranch")
    private Branch holdingbranch;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @Column(name = "location", length = 80)
    private String location;

    @Column(name = "permanent_location", length = 80)
    private String permanentLocation;

    @Column(name = "cn_source", length = 10)
    private String cnSource;

    @Column(name = "cn_sort")
    private String cnSort;

    @Column(name = "ccode", length = 80)
    private String ccode;

    @Lob
    @Column(name = "uri")
    private String uri;

    @Column(name = "itype", length = 10)
    private String itype;

    @Column(name = "copynumber", length = 32)
    private String copynumber;

}
