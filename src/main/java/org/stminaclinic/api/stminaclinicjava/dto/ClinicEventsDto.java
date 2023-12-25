package org.stminaclinic.api.stminaclinicjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClinicEventsDto {
    private Date date;
    private String uuid;
    private Timestamp createDate;
}
