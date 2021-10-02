package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Expenses extends BasicEntity {
    @Column(name = "amount", nullable = false)
    private double amount;
    @Column(name = "amount_date", nullable = false)
    private LocalDate amountDate;
    @Column(name = "reason")
    private String reason;
    @Column(name = "comment")
    private String comment;

}
