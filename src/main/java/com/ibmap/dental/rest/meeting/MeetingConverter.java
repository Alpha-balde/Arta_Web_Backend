package com.ibmap.dental.rest.meeting;

import com.ibmap.dental.domaine.entities.Meeting;
import com.ibmap.dental.rest.frontdto.Converter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class MeetingConverter implements Converter <Meeting,MeetingFrontDto> {
    @Override
    public Meeting toEntity(@NonNull MeetingFrontDto frontDto) {
        return Meeting.builder()
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .title(frontDto.getTitle())
                .startMeeting(frontDto.getStartMeeting())
                .endMeeting(frontDto.getEndMeeting())
                .location(frontDto.getLocation())
                .agenda(frontDto.getAgenda())
                .attendeesList(new ArrayList<>(frontDto.getAttendeesList()))// to be tested
                .statementMeeting(frontDto.getStatementMeeting())
                .build();
    }

    @Override
    public MeetingFrontDto toFrontDto(@NonNull Meeting entity) {
        return MeetingFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .title(entity.getTitle())
                .startMeeting(entity.getStartMeeting())
                .endMeeting(entity.getEndMeeting())
                .location(entity.getLocation())
                .agenda(entity.getAgenda())
                .attendeesList(new ArrayList<>(entity.getAttendeesList()))// to be tested
                .statementMeeting(entity.getStatementMeeting())
                .build();
    }
}
