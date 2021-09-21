package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "memberFamily")
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode (callSuper = true)
@ToString(callSuper = true)
public class MemberFamily extends BasicEntity {
    /*
    @OneToMany(mappedBy = "memberFamily")
    private List<Member> members;
    @OneToMany(mappedBy = "memberFamily")
    private List<Family> families;
    @Column(name = "comments")
    private String comments;

     */
}
