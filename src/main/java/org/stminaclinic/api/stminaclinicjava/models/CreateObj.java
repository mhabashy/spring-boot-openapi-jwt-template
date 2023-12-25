package org.stminaclinic.api.stminaclinicjava.models;

import lombok.Data;

@Data
public class CreateObj {
    private String uuid; 
    public CreateObj(String uuid) {
        this.uuid = uuid;
    }
}
