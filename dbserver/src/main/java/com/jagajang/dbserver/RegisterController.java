package com.jagajang.dbserver;

import com.jagajang.dbserver.dto.UserInfo;
import com.jagajang.dbserver.dto.UserRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RegisterController {
    @PostMapping("/register")
    public Boolean registerUser(UserRegister registerInfo) {
        registerInfo

        return false;
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
