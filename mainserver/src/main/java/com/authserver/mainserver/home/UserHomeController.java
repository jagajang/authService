package com.authserver.mainserver.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserHomeController {
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("role", "GUEST");

        return "home";
    }
}
