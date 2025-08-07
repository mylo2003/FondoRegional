package com.backend.FondoRegional.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @ColumnDefault("''")
    @Column(name = "branchcode", nullable = false, length = 10)
    private String branchcode;

    @Lob
    @Column(name = "branchname", nullable = false)
    private String branchname;

    @Lob
    @Column(name = "branchaddress1")
    private String branchaddress1;

    @Lob
    @Column(name = "branchaddress2")
    private String branchaddress2;

    @Lob
    @Column(name = "branchcity")
    private String branchcity;

    @Lob
    @Column(name = "branchstate")
    private String branchstate;

    @Lob
    @Column(name = "branchcountry")
    private String branchcountry;

    @Lob
    @Column(name = "branchphone")
    private String branchphone;

    @Lob
    @Column(name = "branchemail")
    private String branchemail;

    @Column(name = "marcorgcode", length = 16)
    private String marcorgcode;

    //TODO [Reverse Engineering] generate columns from DB
}