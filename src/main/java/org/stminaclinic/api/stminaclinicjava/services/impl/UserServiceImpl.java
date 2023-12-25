package org.stminaclinic.api.stminaclinicjava.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stminaclinic.api.stminaclinicjava.dto.UserDto;
import org.stminaclinic.api.stminaclinicjava.exceptions.UserNotFoundException;
import org.stminaclinic.api.stminaclinicjava.models.Users;
import org.stminaclinic.api.stminaclinicjava.repository.UserRepository;
import org.stminaclinic.api.stminaclinicjava.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired()
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto getLoginToken(String email, String password) {
        String passwordHASH = this.MD5(password);
        Users user = this.userRepository.findByEmail(email);
        if (user == null && user.getPassword() != passwordHASH) {
            throw new UserNotFoundException("User not found!");
        }
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUuid(user.getUuid());
        userDto.setFullName(user.getFullName());
        userDto.setAccessToken("HELLO_WORLD!");
        return userDto;
    }

    private String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
