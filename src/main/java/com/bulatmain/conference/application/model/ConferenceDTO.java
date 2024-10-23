package com.bulatmain.conference.application.model;

import com.bulatmain.conference.domain.common.value.Description;
import com.bulatmain.conference.domain.conference.entity.Conference;
import com.bulatmain.conference.domain.conference.value.ConferenceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceDTO {
    String id;
    String name;
    UserDTO organizer;
    String subject;
    Description description;
    String location;
    DateTime startingDate;
    DateTime endingDate;
    ConferenceStatus status;

    public ConferenceDTO(Conference conference) {
        id = conference.getId().toString();
        name = conference.getName();
        organizer = UserDTO.of(conference.getOrganizer());
        subject = conference.getDetail().getSubject();
        description = conference.getDetail().getDescription();
        location = conference.getDetail().getLocation().toString();
        startingDate = conference.getDetail().getStartingDate();
        endingDate = conference.getDetail().getEndingDate();
        status = conference.getStatus();
    }

    public static ConferenceDTO of(Conference conference) {
        return new ConferenceDTO(conference);
    }


}
