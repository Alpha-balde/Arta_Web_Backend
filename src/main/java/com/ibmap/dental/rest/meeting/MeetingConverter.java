package com.ibmap.dental.rest.meeting;

import com.ibmap.dental.domaine.entities.Meeting;
import com.ibmap.dental.rest.frontdto.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class MeetingConverter implements Converter <Meeting,MeetingFrontDto> {
    @Override
    public Meeting toEntity(MeetingFrontDto frontDto) {
        return Meeting.builder()
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .title(frontDto.getTitle())
                .startMeeting(frontDto.getStartMeeting())
                .endMeeting(frontDto.getEndMeeting())
                .location(frontDto.getLocation())
                .agenda(frontDto.getAgenda())
                .attendeesList(frontDto.getAttendeesList().stream().collect(Collectors.toList()))// to be tested
                .statementMeeting(frontDto.getStatementMeeting())
                .build();
    }

    @Override
    public MeetingFrontDto toFrontDto(Meeting entity) {
        return MeetingFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .title(entity.getTitle())
                .startMeeting(entity.getStartMeeting())
                .endMeeting(entity.getEndMeeting())
                .location(entity.getLocation())
                .agenda(entity.getAgenda())
                .attendeesList(entity.getAttendeesList().stream().collect(Collectors.toList()))// to be tested
                .statementMeeting(entity.getStatementMeeting())
                .build();
    }
}
