package com.bulatmain.conference.application.factory;

import com.bulatmain.conference.application.factory.exception.IllegalInputException;

public interface Factory<T, DTO> {
    T build(DTO dto) throws IllegalInputException;
}
