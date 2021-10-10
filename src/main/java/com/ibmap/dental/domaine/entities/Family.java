package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "family")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode (callSuper = true)
@ToString(callSuper = true)
public class Family extends BasicEntity {

    @Column(name = "family_id", nullable = false,unique = true)
    private String familyId;
    //@Column(name = "head_person", nullable = false)
    //@OneToOne(mappedBy = "id")
    //private Member headPerson;


}
