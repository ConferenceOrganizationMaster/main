package com.bulatmain.conference.domain.conference.entity;

import com.bulatmain.conference.domain.conference.entity.exception.IllegalEventDateException;
import com.bulatmain.conference.domain.conference.entity.exception.NoRequiredRoleException;
import com.bulatmain.conference.domain.conference.value.ConferenceDetail;
import com.bulatmain.conference.domain.conference.value.ConferenceStatus;
import com.bulatmain.conference.domain.user.entity.User;

public class ConferenceCreator {
    public Conference create(String name, User organizer) throws NoRequiredRoleException {
        var conf = Conference.build(
                name,
                organizer
        );
        conf.setStatus(ConferenceStatus.BLANK);
        return conf;
    }

    public Conference create(String name,  User organizer, ConferenceDetail detail)
            throws IllegalEventDateException, NoRequiredRoleException {
        ConferenceStatus status = defineStatus(detail);
        var conf = Conference.build(
                name,
                organizer
        );
        conf.setDetail(detail);
        conf.setStatus(status);
        return conf;
    }

    private ConferenceStatus defineStatus(ConferenceDetail detail)
            throws IllegalEventDateException {
        if (detail == null || !detail.filled()) {
            return ConferenceStatus.BLANK;
        } else if (detail.getStartingDate().isAfterNow()) {
            return ConferenceStatus.EXPECTED;
        } else {
            throw new IllegalEventDateException("Error: can not create conference after it's starting date.");
        }
    }


}
