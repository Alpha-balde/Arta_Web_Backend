package com.ibmap.dental.rest.memberHistory;

import com.ibmap.dental.domaine.entities.Member;
import com.ibmap.dental.domaine.entities.MemberHistory;
import com.ibmap.dental.rest.frontdto.Converter;
import com.ibmap.dental.rest.member.MemberConverter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberHistoryConverter implements Converter<MemberHistory,MemberHistoryFrontDto> {
    private MemberConverter memberConverter;
    @Autowired
    public MemberHistoryConverter(MemberConverter memberConverter) {
        this.memberConverter = memberConverter;
    }

    @Override
    public MemberHistory toEntity(@NonNull MemberHistoryFrontDto frontDto) {
        return MemberHistory.builder()
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .member(memberConverter.toEntity(frontDto.getMember()))
                .modificationDate(frontDto.getModificationDate())
                .columnName(frontDto.getColumnName())
                .oldValue(frontDto.getOldValue())
                .newValue(frontDto.getNewValue())
                .build();
    }

    @Override
    public MemberHistoryFrontDto toFrontDto(@NonNull MemberHistory entity) {
        return MemberHistoryFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .member(memberConverter.toFrontDto(entity.getMember()))
                .modificationDate(entity.getModificationDate())
                .columnName(entity.getColumnName())
                .oldValue(entity.getOldValue())
                .newValue(entity.getNewValue())
                .build();
    }
}
