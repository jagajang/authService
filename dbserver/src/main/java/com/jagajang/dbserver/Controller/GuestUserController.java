package com.jagajang.dbserver.Controller;

import com.jagajang.dbserver.DBService;
import com.jagajang.dbserver.type.dto.UserMailPassName;
import com.jagajang.dbserver.type.dto.UserResponseInfo;
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
}
