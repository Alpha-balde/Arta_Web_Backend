package com.ibmap.dental.rest.meeting;

import com.ibmap.dental.application.services.MeetingService;
import com.ibmap.dental.domaine.entities.Meeting;
import com.ibmap.dental.repositories.MeetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/meetings")
@Slf4j
public class MeetingRestController {

    private MeetingConverter meetingConverter;
    private MeetingService meetingService;

    public MeetingRestController(MeetingConverter meetingConverter, MeetingService meetingService) {
        this.meetingConverter = meetingConverter;
        this.meetingService = meetingService;
    }

    @GetMapping
    public ResponseEntity<List<MeetingFrontDto>> getAll() {
        List<Meeting> meeting = meetingService.findAll();
        List<MeetingFrontDto> frontDtos = meetingConverter.toFrontDtos(meeting);
        return ResponseEntity.status(HttpStatus.OK).body(frontDtos);
    }

    @GetMapping(value = "/{businessKey}")
    public ResponseEntity<MeetingFrontDto> getByBusinessKey(@PathVariable String businessKey) {
        Meeting meeting = meetingService.findByBusinessKey(businessKey);
        MeetingFrontDto frontDto = meetingConverter.toFrontDto(meeting);
        return ResponseEntity.status(HttpStatus.OK).body(frontDto);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MeetingFrontDto frontDto) {
        Meeting meeting = meetingConverter.toEntity(frontDto);
        Meeting savedmeeting = meetingService.save(meeting);
        frontDto = meetingConverter.toFrontDto(savedmeeting);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI meetingsUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{businessKey}")
                .buildAndExpand(frontDto.getBusinessKey())
                .toUri();
        responseHeaders.setLocation(meetingsUri);

        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeaders).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody MeetingFrontDto frontDto) {
        this.meetingService.update(meetingConverter.toEntity(frontDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{businessKey}")
    public ResponseEntity<?> delete(@PathVariable(required = true) String businessKey) {
        meetingService.deleteByBusinessKey(businessKey);
        return ResponseEntity.ok().build();
    }


}
