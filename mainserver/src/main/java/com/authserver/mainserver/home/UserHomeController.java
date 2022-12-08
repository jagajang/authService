package com.authserver.mainserver.home;

import com.authserver.mainserver.home.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserHomeController {
    @Autowired
    SearchService searchService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("role", "GUEST");

        return "home";
    }

    @GetMapping("/search")
    public String searchUser(
            Model model,
            @RequestParam(value = "nickname") String nickname) {
        model.addAttribute("users", searchService.searchUsersWithNickname(nickname));

        return "home";
    }
}
