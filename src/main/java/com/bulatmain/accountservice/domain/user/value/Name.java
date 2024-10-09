package com.bulatmain.accountservice.domain.user.value;

import com.bulatmain.accountservice.domain.user.value.exception.IllegalNameException;
import lombok.Getter;
import lombok.val;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Name {
    private final String name;
    private final String surname;

    private Name(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Name build(String fullName) throws IllegalNameException {
        Pair<String, String> pair = splitFullName(fullName);
        return new Name(pair.first, pair.second);
    }

    Pair<String, String> splitFullName(String fullName) throws IllegalNameException {
        if (!fullName.matches(" *\\w* *\\w* *")) {
            throw new IllegalNameException(
                    String.format("Error: invalid full name: %s.\nFull name should consist of name and surname", fullName)
            );
        }
        Scanner scanner = new Scanner(fullName);
        return new Pair<String, String>(
                scanner.next("\\w"),
                scanner.next("\\w")
        );
    }

    private static record Pair<T, U>(T first, U second) {}
}
