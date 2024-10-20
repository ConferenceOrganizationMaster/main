package com.bulatmain.conference.domain.conference.value;

import com.bulatmain.conference.domain.common.value.Id;

public class ConferenceId implements Id {
    private String record;

    public ConferenceId(String userEmail, String conferenceName) {
        // Step 1: Extract email prefix (before '@')
        String emailPrefix = userEmail.split("@")[0];

        // Step 2: Replace spaces in the conference name with dashes
        String cleanConfName = conferenceName.replace(" ", "-");

        // Step 3: Concatenate and return the result in lowercase
        record = (emailPrefix + "-" + cleanConfName).toLowerCase();
    }

    @Override
    public String toString() {
        return record;
    }
}
