package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.application.typology.PaymentMode;
import com.ibmap.dental.application.typology.PaymentType;
import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Payment extends BasicEntity {
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_mode", nullable = false)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    @Column( name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_amount", nullable = false)
    private double payment_amount;

    @Column(name = "comment", nullable = true, columnDefinition = "TEXT")
    private String comment;
}
