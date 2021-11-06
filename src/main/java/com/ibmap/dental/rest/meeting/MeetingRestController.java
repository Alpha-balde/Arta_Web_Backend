package com.ibmap.dental.rest.meeting;

import com.ibmap.dental.application.services.IMeetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController("/meeting")
@Slf4j
public class MeetingRestController {

    private MeetingConverter meetingConverter;
    private IMeetingService meetingService;

    public MeetingRestController(MeetingConverter meetingConverter, IMeetingService meetingService) {
        this.meetingConverter = meetingConverter;
        this.meetingService = meetingService;
    }

    // GET

    // GET ALL

    // POST

    // PUT

    // DELETE


}
