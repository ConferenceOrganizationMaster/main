package com.bulatmain.conference.application.port;

import com.bulatmain.conference.application.model.ConferenceDTO;

public interface ConferenceGateway {
    void register(ConferenceDTO conferenceDTO);
}
