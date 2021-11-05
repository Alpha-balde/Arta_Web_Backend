package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
abstract class CommonFees extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "MERMBER_COMMMON_FEES_FK"))
    private Member member;

    @ManyToOne
    @JoinColumn(name = "payment_id", foreignKey = @ForeignKey(name = "PAYMENT_COMMMON_FEES_FK"))
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "metadata_id", foreignKey = @ForeignKey(name = "METADATA_COMMMON_FEES_FK"))
    private Metadata metadata;

    @Column(name = "year", nullable = false)
    private int year;

}
