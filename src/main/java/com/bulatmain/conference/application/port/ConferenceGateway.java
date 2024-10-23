package com.bulatmain.conference.application.port;

import com.bulatmain.conference.application.model.ConferenceDTO;

import java.util.Optional;

public interface ConferenceGateway {
    void register(ConferenceDTO conferenceDTO);

    Optional<ConferenceDTO> findByName(String name);
}
