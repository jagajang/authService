package com.jagajang.dbserver;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * request user information without email & password
 */
@RestController
@RequestMapping("/get")
public class GetInfo {
    @PostMapping("/email")
    public String checkEmailExist() {
        return "";
    }

    @PostMapping("/nickname")
    public String getNickname() {
        return "";
    }
}
