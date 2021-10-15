package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Insurance extends BasicEntity {
    @Column(name = "Insurance_date", nullable = false)
    private LocalDate insuranceDate;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;
    @OneToOne(targetEntity = Metadata.class)
    @Column(name = "metadata_id",nullable = false)
    private Long metadataID;

    @OneToOne(targetEntity = Payment.class)
    @Column(name = "payment_id")
    private Long paymentID;


}
