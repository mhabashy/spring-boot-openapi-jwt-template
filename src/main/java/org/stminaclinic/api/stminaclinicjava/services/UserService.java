package org.stminaclinic.api.stminaclinicjava.services;

import org.stminaclinic.api.stminaclinicjava.dto.UserDto;

public interface UserService {
    UserDto getLoginToken(String email, String password);

}
