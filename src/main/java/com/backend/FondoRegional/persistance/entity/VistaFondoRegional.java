package com.backend.FondoRegional.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vista_fondo_regional")
@Immutable
public class VistaFondoRegional {
    @Id
    private Integer itemnumber;

    private String barcode;
    private String homebranch;
    private String location;
    private String itype;
    private String copynumber;

    private String editionstatement;
    private String publishercode;
    private String pages;
    private String size;
    private String isbn;

    private String author;
    private String title;
    private String notes;
    @Column(name = "abstract")
    private String abstractText;

    private String branchname;
    private String branchaddress1;
    private String branchaddress2;
    private String branchcity;
    private String branchstate;
    private String branchcountry;
    private String branchphone;
    private String branchemail;
}
