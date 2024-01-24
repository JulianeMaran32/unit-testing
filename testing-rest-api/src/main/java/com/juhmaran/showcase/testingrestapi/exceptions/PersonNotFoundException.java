package com.juhmaran.showcase.testingrestapi.exceptions;

import lombok.Getter;

@Getter
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String message) {
        super(message);
    }
}
