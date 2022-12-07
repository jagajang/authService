package com.authserver.mainserver.api;

import com.authserver.mainserver.api.db.DBWebClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class ApiTestController {
    @Autowired
    DBWebClientServiceImpl dbWebClientService;

    @GetMapping("/db-api")
    public String apiTest() {
        return dbWebClientService.apiTest();
    }
}
