package org.library.backend.util.error.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String messagge) {
        super(messagge);
    }
}
