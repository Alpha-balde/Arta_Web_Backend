package com.ibmap.dental.domaine.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Contribution extends  CommonFees {

    @Column(name = "contribution_month", nullable = false)
    @Enumerated(EnumType.STRING)
    private Month month;
}
