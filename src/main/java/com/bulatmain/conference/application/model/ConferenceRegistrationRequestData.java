package com.bulatmain.conference.application.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConferenceRegistrationRequestData {
    String name;
    String organizerEmail;
}
