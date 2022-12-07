package com.jagajang.dbserver;

import com.jagajang.dbserver.type.dto.UserInfo;
import com.jagajang.dbserver.type.dto.UserInfoName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RegisterController {
    @Autowired
    private DBService dbService;

    @GetMapping("/register")
    public String registerTest() {
        dbService.registerUser(new UserInfoName(
                "newUser",
                "pass",
                "name"));

        return "";
    }

    @PostMapping("/register")
    public Boolean registerUser(UserInfoName registerInfo) {
        log.info(registerInfo.getEmail());
        log.info(registerInfo.getPassword());
        log.info(registerInfo.getNickname());

        return dbService.registerUser(registerInfo);
    }

    @PostMapping("/is-admin")
    public ResponseEntity<Boolean> isAdmin(
            @RequestBody UserInfo userInfo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(false);
        } catch(Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
