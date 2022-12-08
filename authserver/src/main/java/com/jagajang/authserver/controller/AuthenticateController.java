package com.jagajang.authserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
    @PostMapping("/login")
    public String userLogin() {
        return "";
    }
}
