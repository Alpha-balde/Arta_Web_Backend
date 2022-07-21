package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.application.typology.PaymentMode;
import com.ibmap.dental.application.typology.PaymentType;
import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Insurance> insurance = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Contribution> contribution = new ArrayList<>();


    public Payment update(Payment payment){
        paymentDate=payment.paymentDate;
        paymentMode=payment.paymentMode;
        paymentType=payment.paymentType;
        payment_amount=payment.payment_amount;
        comment=payment.comment;
        insurance=payment.insurance;
        contribution=payment.contribution;
        return this;
    }

}
