package com.ibmap.dental.rest.member;

import com.ibmap.dental.domaine.entities.Member;
import com.ibmap.dental.rest.frontdto.Converter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MemberConverter implements Converter<Member, MemberFrontDto> {
    @Override
    public Member toEntity(@NonNull MemberFrontDto frontDto) {
        return null;
    }

    @Override
    public MemberFrontDto toFrontDto(@NonNull Member entity) {
        return null;
    }
}
