package com.ibmap.dental.rest.family;

import com.ibmap.dental.rest.frontdto.FrontDto;
import com.ibmap.dental.rest.member.MemberFrontDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FamilyFrontDto implements FrontDto {
    private MemberFrontDto headPerson;
    private List<MemberFrontDto> familyMember;
    private String comments;

}
