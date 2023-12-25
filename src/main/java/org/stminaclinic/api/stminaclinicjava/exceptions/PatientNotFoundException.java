package org.stminaclinic.api.stminaclinicjava.exceptions;

public class PatientNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;
    public PatientNotFoundException(String message) {
        super(message);
    }

}
