package com.jagajang.dbserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApiTest {
    @GetMapping("/api-test")
    public String apiTestGet() {
        log.info("get test");
        return "api get test success";
    }

    @PostMapping("/api-test")
    public String apiTestPost() {
        log.info("post test");
        return "api post test success";
    }
}
