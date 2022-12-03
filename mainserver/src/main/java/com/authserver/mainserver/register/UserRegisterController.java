package com.authserver.mainserver.register;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserRegisterController {
    @GetMapping("/register")
    public String registerGet() {
        return "userpage/register";
    }

    @PostMapping("/register")
    public String registerPost(RegisterForm form) {
        log.info(form.getUsername());
        log.info(form.getPassword());

        return "redirect:/";
    }
}
