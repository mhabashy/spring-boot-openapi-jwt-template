package org.stminaclinic.api.stminaclinicjava.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long SerialVersionUID = 1;

    public UserNotFoundException(String message) {
        super(message);
    }

}
