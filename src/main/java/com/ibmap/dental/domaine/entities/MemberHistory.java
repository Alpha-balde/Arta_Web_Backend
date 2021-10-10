package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MemberHistory extends BasicEntity {
    // @Column(name = "member_id",nullable = false)
    //@ManyToOne
    //private Member member;
    @Column(name = "column_name", nullable = false)
    private String columnName;
    @Column(name = "modification_date",nullable = false)
    private LocalDate modificationDate;
    @Column(name = "old_value", nullable = false)
    private String oldValue;
    @Column(name = "new_value", nullable = false)
    private String newValue;
}
