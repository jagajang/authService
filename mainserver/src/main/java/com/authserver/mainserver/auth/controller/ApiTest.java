package com.authserver.mainserver.auth.controller;

import com.authserver.mainserver.api.db.DBWebClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApiTest {
    @Autowired
    DBWebClientServiceImpl dbWebClientService;

    @GetMapping("/api-test")
    public String apiTest() {
        String result = dbWebClientService.apiTest();

        log.info(result);

        return result;
    }
}
