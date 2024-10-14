package com.bulatmain.conference.domain.common.value.validator;

public interface Validator<T> {
    boolean check(T obj);
}
