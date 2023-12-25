package org.stminaclinic.api.stminaclinicjava.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.stminaclinic.api.stminaclinicjava.dto.UserDto;
import org.stminaclinic.api.stminaclinicjava.models.JwtRequest;
import org.stminaclinic.api.stminaclinicjava.models.JwtResponse;
import org.stminaclinic.api.stminaclinicjava.security.CustomUserDetailsService;
import org.stminaclinic.api.stminaclinicjava.security.JwtTokenUtil;
import org.stminaclinic.api.stminaclinicjava.services.UserService;

@RestController
public class UserController {
    private UserService userService;
    private CustomUserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired()
    UserController(UserService userService,
                   CustomUserDetailsService userDetailsService,
                   JwtTokenUtil jwtTokenUtil
    ) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("api/v1/auth/token")
    @Operation(summary = "get access token")
    private ResponseEntity<JwtResponse> requestUserToken(@RequestBody JwtRequest loginRequest) {
        UserDto userDto = this.userService.getLoginToken(loginRequest.getEmail(), loginRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getEmail());
        final String token = this.jwtTokenUtil.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setAccessToken(token);
        return new ResponseEntity< JwtResponse >(jwtResponse, HttpStatus.CREATED);
    }

}
