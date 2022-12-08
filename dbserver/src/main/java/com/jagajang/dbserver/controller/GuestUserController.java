package com.jagajang.dbserver.controller;

import com.jagajang.dbserver.DBService;
import com.jagajang.dbserver.type.dto.UserMailPass;
import com.jagajang.dbserver.type.dto.UserMailPassName;
import com.jagajang.dbserver.type.dto.UserResponseInfo;
import com.jagajang.dbserver.type.enums.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class GuestUserController {
    @Autowired
    private DBService dbService;

    @PostMapping("/register")
    public Boolean registerUser(UserMailPassName registerInfo) {
        return dbService.registerUser(registerInfo);
    }

    @PostMapping("/search-all")
    public List<UserResponseInfo> searchUsers(String nickname) {
        return dbService.findUsersByNickname(nickname);
    }

    @PostMapping("/user-exist")
    public UserRole existUser(UserMailPass loginInfo) {
        return dbService.validUser(loginInfo);
    }
}
