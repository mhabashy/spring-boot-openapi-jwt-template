package org.stminaclinic.api.stminaclinicjava.exceptions;

public class ClinicEventsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public ClinicEventsNotFoundException(String message) {
        super(message);
    }
}
