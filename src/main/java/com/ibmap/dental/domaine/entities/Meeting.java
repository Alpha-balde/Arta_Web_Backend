package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

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
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "attendees_list")
    private String attendeesList;
    @Column(name = "statement_meeting", columnDefinition = "TEXT")
    private String statementMeeting;

}
