package org.stminaclinic.api.stminaclinicjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String fullName;
    private String email;
    private String uuid;
    private String accessToken;
}
