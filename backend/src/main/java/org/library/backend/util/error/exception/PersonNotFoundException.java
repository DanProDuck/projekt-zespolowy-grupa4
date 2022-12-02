package org.library.backend.util.error.exception;

import java.util.function.Supplier;

public class PersonNotFoundException extends RuntimeException implements Supplier<PersonNotFoundException> {
    private final int id;

    public PersonNotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public PersonNotFoundException get() {
        return this;
    }
}
