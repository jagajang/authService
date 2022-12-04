package com.authserver.mainserver.auth.controller;

import com.authserver.mainserver.auth.dto.UserInfoForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserLoginController {
    @GetMapping("/login")
    public String loginGet() {
        return "userpage/login";
    }

    @PostMapping("/login")
    public String loginPost(UserInfoForm form) {
        log.info(form.getEmail());
        log.info(form.getPassword());

        return "redirect:/";
    }
}
