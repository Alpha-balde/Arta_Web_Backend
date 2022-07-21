package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder

public class MemberHistory extends BasicEntity {
    @ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "MEMBER_MEMBER_HISTORY_FK"))
    private Member member;
    @Column(name = "column_name", nullable = false)
    private String columnName;
    @Column(name = "modification_date",nullable = false)
    private LocalDate modificationDate;
    @Column(name = "old_value", nullable = false)
    private String oldValue;
    @Column(name = "new_value", nullable = false)
    private String newValue;

    public MemberHistory update(MemberHistory memberHistory){
        this.member = memberHistory.member;
        this.columnName = memberHistory.columnName;
        this.modificationDate = memberHistory.modificationDate;
        this.oldValue = memberHistory.oldValue;
        this.newValue = memberHistory.newValue;
        return  this;
    }
}
