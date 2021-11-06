package com.ibmap.dental.rest.meeting;

import com.ibmap.dental.rest.frontdto.FrontDto;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MeetingFrontDto implements FrontDto {
    private String businessKey;
    private Instant createdOn;
    @NotBlank
    private String title;
    @FutureOrPresent
    private LocalDate startMeeting;
    @Future
    private LocalDate endMeeting;
    @NotBlank
    private String location;
    private String agenda;
    private List<String> attendeesList;
    // TODO: use quil editore for this
    private String statementMeeting;
}
