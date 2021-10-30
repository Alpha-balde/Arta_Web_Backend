package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(
            mappedBy = "family",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Member headPerson;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Member> FamilyMember = new ArrayList<>();

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;
}
