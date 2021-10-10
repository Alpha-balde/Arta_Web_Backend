package com.ibmap.dental.domaine.entities;


import com.ibmap.dental.application.typology.Month;
import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Contribution extends BasicEntity {

    //@ManyToOne(targetEntity = Member.class)
    @Column(name = "member_id",nullable = false)
    private long memberID;

    @Column(name = "contribution_year", nullable = false)
    private int contributionYear;

    @Column(name = "contribution_month", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Month contributionMonth;

    //@OneToOne(targetEntity = Metadata.class)
    @Column(name = "metadata_id",nullable = false)
    private Long metadataID;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    //@OneToMany(targetEntity = Payment.class)
    @Column(name = "payment_id")
    private Long paymentID;
}
