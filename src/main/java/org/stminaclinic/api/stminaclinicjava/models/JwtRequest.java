package org.stminaclinic.api.stminaclinicjava.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    private String email;
    private String password;
}