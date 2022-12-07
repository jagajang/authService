package com.jagajang.dbserver.Controller;

import com.jagajang.dbserver.DBService;
import com.jagajang.dbserver.type.dto.UserInfoName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GuestUserController {
    @Autowired
    private DBService dbService;

    @PostMapping("/register")
    public Boolean registerUser(UserInfoName registerInfo) {
        return dbService.registerUser(registerInfo);
    }
}
