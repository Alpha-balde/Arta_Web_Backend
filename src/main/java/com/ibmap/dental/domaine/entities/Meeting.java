package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Meeting extends BasicEntity {
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "start_meeting")
    private LocalDate startMeeting;
    @Column(name = "end_meeting")
    private LocalDate endMeeting;
    @Column(name = "location")
    private String location;
    @Column(name = "agenda")
    private String agenda;
    @Column(name = "attendees_list")
    @ElementCollection
    private List<String> attendeesList = new ArrayList<>();
    @Column(name = "statement_meeting", columnDefinition = "TEXT")
    private String statementMeeting;

    public Meeting update(Meeting meeting) {
        this.title = meeting.title;
        this.startMeeting = meeting.startMeeting;
        this.endMeeting = meeting.endMeeting;
        this.location = meeting.location;
        this.agenda = meeting.agenda;
        this.attendeesList = new ArrayList<>(meeting.getAttendeesList());
        this.statementMeeting = meeting.statementMeeting;
        return this;
    }

}
