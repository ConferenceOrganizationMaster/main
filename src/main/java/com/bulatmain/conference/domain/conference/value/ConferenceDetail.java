package com.bulatmain.conference.domain.conference.value;

import com.bulatmain.conference.domain.common.value.Description;
import com.bulatmain.conference.domain.common.value.Location;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

@Data
@Builder
public class ConferenceDetail {
    private final String subject;
    private final Description description;
    private final Location location;

    private final DateTime startingDate;
    private final DateTime endingDate;

    public boolean filled() {
        return  subject != null &&
                description != null &&
                location != null &&
                startingDate != null &&
                endingDate != null;
    }

}
