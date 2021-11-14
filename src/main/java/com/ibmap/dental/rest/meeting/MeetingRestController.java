package com.ibmap.dental.rest.meeting;

import com.ibmap.dental.application.exception.ErrorDetails;
import com.ibmap.dental.application.services.MeetingService;
import com.ibmap.dental.domaine.entities.Meeting;
import com.ibmap.dental.repositories.MeetingRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "recover all meetings from the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Found the meetings",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MeetingFrontDto.class))
                    )}),
    })
    @GetMapping
    public ResponseEntity<List<MeetingFrontDto>> getAll() {
        List<Meeting> meeting = meetingService.findAll();
        List<MeetingFrontDto> frontDtos = meetingConverter.toFrontDtos(meeting);
        return ResponseEntity.status(HttpStatus.OK).body(frontDtos);
    }

    @Operation(summary = "Get a meeting by its business key")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the meeting",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MeetingFrontDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid business key supplied",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
    })
    @GetMapping(value = "/{businessKey}")
    public ResponseEntity<MeetingFrontDto> getByBusinessKey(
            @PathVariable String businessKey) {
        Meeting meeting = meetingService.findByBusinessKey(businessKey);
        MeetingFrontDto frontDto = meetingConverter.toFrontDto(meeting);
        return ResponseEntity.status(HttpStatus.OK).body(frontDto);
    }

    @Operation(summary = "Create a meeting ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The meeting was created successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MeetingFrontDto.class))})
    })
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

    @Operation(summary = "update a meeting using the businee key")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "205", description = "The meeting was updated/reseted successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MeetingFrontDto.class))})
    })
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MeetingFrontDto frontDto) {
        Meeting meeting = this.meetingService.update(meetingConverter.toEntity(frontDto));
        frontDto = meetingConverter.toFrontDto(meeting);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(frontDto);
    }

    @Operation(summary = "delete a meeting using its businee key")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The meeting was deleted successfully",
                    content = @Content)
    })
    @DeleteMapping(value = "/{businessKey}")
    public ResponseEntity<?> delete(@PathVariable String businessKey) {
        meetingService.deleteByBusinessKey(businessKey);
        return ResponseEntity.ok().build();
    }


}
