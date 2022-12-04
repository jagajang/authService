package com.authserver.mainserver.auth.controller;

import com.authserver.mainserver.auth.dto.UserRegisterForm;
import com.authserver.mainserver.auth.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserRegisterController {
    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String registerGet() {
        return "userpage/register";
    }

    @PostMapping("/register")
    public String registerPost(UserRegisterForm form) {
        try {
            registerService.register(form);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return "redirect:/";
    }
}
