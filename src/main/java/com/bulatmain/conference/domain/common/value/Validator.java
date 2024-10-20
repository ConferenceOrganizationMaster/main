package com.bulatmain.conference.domain.common.value;

public interface Validator<T> {
    boolean check(T obj);

}
