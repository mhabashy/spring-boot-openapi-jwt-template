package org.stminaclinic.api.stminaclinicjava.models;

import lombok.Data;

@Data
public class ErrorObj {
    private int statusCode;
    private String message;
}
