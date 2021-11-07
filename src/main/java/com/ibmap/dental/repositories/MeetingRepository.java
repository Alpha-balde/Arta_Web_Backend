package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Meeting;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CommonsRepository<Meeting, Long> {

}
