package org.stminaclinic.api.stminaclinicjava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.stminaclinic.api.stminaclinicjava.models.ErrorObj;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClinicEventsNotFoundException.class)
    public ResponseEntity<ErrorObj> handleClinicEventNotFoundException(ClinicEventsNotFoundException ex, WebRequest request) {

        ErrorObj errorObject = new ErrorObj();

        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(ex.getMessage());

        return new ResponseEntity<ErrorObj>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorObj> handlePatientsNotFoundException(PatientNotFoundException ex, WebRequest request) {

        ErrorObj errorObject = new ErrorObj();

        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(ex.getMessage());

        return new ResponseEntity<ErrorObj>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorObj> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {

        ErrorObj errorObject = new ErrorObj();

        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(ex.getMessage());

        return new ResponseEntity<ErrorObj>(errorObject, HttpStatus.NOT_FOUND);
    }

}