package com.authserver.mainserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserHomeController {
    @RequestMapping("/")
    public String home() {
        return "userpage/home";
    }
}
