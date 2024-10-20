package com.bulatmain.conference.domain.common.value;

public interface Description {
    default String get() {
        return toString();
    }

    String toString();
}
