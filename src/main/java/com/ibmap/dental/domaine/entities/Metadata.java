package com.ibmap.dental.domaine.entities;


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
public class Metadata extends BasicEntity {

    @Column(name = "version",  nullable = false)
    private int version;
    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Insurance> insurance = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Contribution> contribution = new ArrayList<>();
}
