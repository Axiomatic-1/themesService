package com.microsevriceslesson.plateService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @GetMapping("/")
    public String getString(){
        return "Hello from profile controller";
    }
}
