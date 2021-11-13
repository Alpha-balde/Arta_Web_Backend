package com.ibmap.dental.rest.family;

import com.ibmap.dental.domaine.entities.Family;
import com.ibmap.dental.rest.frontdto.Converter;
import com.ibmap.dental.rest.member.MemberConverter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class FamilyConverter implements Converter<Family, FamilyFrontDto> {
    private MemberConverter memberConverter;

    public FamilyConverter(MemberConverter memberConverter) {
        this.memberConverter = memberConverter;
    }

    @Override
    public Family toEntity(@NonNull FamilyFrontDto frontDto) {
        return Family.builder()
                .headPerson(memberConverter.toEntity(frontDto.getHeadPerson()))
                .FamilyMember(memberConverter.toEntities(frontDto.getFamilyMember()))
                .comments(frontDto.getComments())
                .build();
    }

    @Override
    public FamilyFrontDto toFrontDto(@NonNull Family entity) {
        return FamilyFrontDto.builder()
                .headPerson(memberConverter.toFrontDto(entity.getHeadPerson()))
                .familyMember(memberConverter.toFrontDtos(entity.getFamilyMember()))
                .comments(entity.getComments())
                .build();
    }
}
