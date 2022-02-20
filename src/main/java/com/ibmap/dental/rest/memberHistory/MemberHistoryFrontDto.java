package com.ibmap.dental.rest.memberHistory;

import com.ibmap.dental.domaine.entities.Member;
import com.ibmap.dental.rest.frontdto.FrontDto;
import com.ibmap.dental.rest.member.MemberFrontDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberHistoryFrontDto implements FrontDto {
    private String businessKey;
    private Instant createdOn;
    @NotNull
    private MemberFrontDto member;
    @NotBlank
    private String columnName;
    @PastOrPresent
    private LocalDate modificationDate;
    @NotBlank
    private String oldValue;
    @NotBlank
    private String newValue;
}
