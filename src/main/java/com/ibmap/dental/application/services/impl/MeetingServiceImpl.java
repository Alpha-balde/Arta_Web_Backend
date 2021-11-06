package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.IMeetingService;
import com.ibmap.dental.repositories.MeetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class
MeetingServiceImpl implements IMeetingService {
    private MeetingRepository meetingRepository;

    public MeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }
}
