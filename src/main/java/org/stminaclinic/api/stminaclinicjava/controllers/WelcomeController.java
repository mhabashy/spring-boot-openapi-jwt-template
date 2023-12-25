package org.stminaclinic.api.stminaclinicjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/api/v1/")
    public String Welcome() {
      return "Hello World; Michael Habashy Demo For Spring Boot";
    };

}
