package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.MeetingService;
import com.ibmap.dental.domaine.entities.Meeting;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.MeetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MeetingServiceImpl implements MeetingService {

    private MeetingRepository meetingRepository;

    public MeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Meeting update(Meeting meeting) {
        Meeting persistedMeeting = this.findByBusinessKey(meeting.getBusinessKey());
        persistedMeeting.update(meeting);
        return save(persistedMeeting);
    }

    @Override
    public CommonsRepository getRepo() {
        return meetingRepository;
    }



}
