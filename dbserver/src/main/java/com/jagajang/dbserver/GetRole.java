package com.jagajang.dbserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GetRole {
    @PostMapping("/is-user")
    public ResponseEntity<Boolean> isUser(
            @RequestBody UserInfo userInfo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch(Exception e) {

            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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

    @PostMapping("/is-user-admin")
    public ResponseEntity<Boolean> isUserAdmin(
            @RequestBody UserInfo userInfo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch(Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
