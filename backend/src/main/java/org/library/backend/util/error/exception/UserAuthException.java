package org.library.backend.util.error.exception;

public class UserAuthException extends RuntimeException{
    public UserAuthException(String message) {
        super(message);
    }
}
