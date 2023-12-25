package org.stminaclinic.api.stminaclinicjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String uuid;
    private Timestamp createdDate;
}
