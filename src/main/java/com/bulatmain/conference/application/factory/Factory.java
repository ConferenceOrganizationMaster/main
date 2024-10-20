package com.bulatmain.conference.application.factory;

public interface Factory<T, DTO> {
    T build(DTO dto);
}
