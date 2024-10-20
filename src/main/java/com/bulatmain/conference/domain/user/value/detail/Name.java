package com.bulatmain.conference.domain.user.value.detail;

import com.bulatmain.conference.domain.user.value.detail.exception.IllegalNameException;
import com.bulatmain.conference.domain.common.value.Validator;
import lombok.Getter;

import java.util.Scanner;

@Getter
public class Name {
    private final String name;
    private final String surname;

    private Name(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static Name build(String fullName, Validator<String> validator) throws IllegalNameException {
        if (!validator.check(fullName)) {
            throw new IllegalNameException(
                    String.format("Error: invalid full name: %s.\nFull name should consist of name and surname", fullName)
            );
        }
        Pair<String, String> pair = splitFullName(fullName);
        return new Name(pair.first, pair.second);
    }

    private static Pair<String, String> splitFullName(String fullName) throws IllegalNameException {
        Scanner scanner = new Scanner(fullName);
        return new Pair<String, String>(
                scanner.next("\\w"),
                scanner.next("\\w")
        );
    }

    private static record Pair<T, U>(T first, U second) {}
}
