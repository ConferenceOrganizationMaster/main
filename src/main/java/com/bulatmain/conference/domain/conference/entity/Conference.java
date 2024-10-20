package com.bulatmain.conference.domain.conference.entity;

import com.bulatmain.conference.domain.conference.entity.exception.NoRequiredRoleException;
import com.bulatmain.conference.domain.conference.value.ConferenceDetail;
import com.bulatmain.conference.domain.conference.value.ConferenceStatus;
import com.bulatmain.conference.domain.user.entity.User;
import com.bulatmain.conference.domain.user.value.role.Organizer;
import org.joda.time.DateTime;

public class Conference {
    private String name;
    private User organizer;
    private ConferenceDetail detail;
    private ConferenceStatus status;

    public static Conference build(String name, User organizer)
            throws NoRequiredRoleException {
        if (!organizer.hasRole(Organizer.class)) {
            throw new NoRequiredRoleException(
                    "Error: conference organizer must have corresponding role."
            );
        }
        return new Conference(name, organizer);
    }

    public void setDetail(ConferenceDetail detail) {
        this.detail = detail;
    }

    public void setStatus(ConferenceStatus status) {
        this.status = status;
    }

    private Conference(String name, User organizer) {
        this.name = name;
        this.organizer = organizer;
    }






}