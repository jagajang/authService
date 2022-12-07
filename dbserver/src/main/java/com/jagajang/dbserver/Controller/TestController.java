package com.jagajang.dbserver.Controller;

import com.jagajang.dbserver.DBService;
import com.jagajang.dbserver.type.dto.UserMailPassName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @Autowired
    DBService dbService;

    @GetMapping("/api")
    public String apiTestGet() {
        log.info("get test");
        return "api get test success";
    }

    @PostMapping("/api")
    public String apiTestPost() {
        log.info("post test");
        return "api post test success";
    }

    @GetMapping("/insert")
    public String dbInsertTest() {
        log.info("insert test");

        if(dbService.registerUser(new UserMailPassName(
                        "email",
                        "pass",
                        "name")))
            return "insert success";
        return "insert fail";
    }

    @GetMapping("/select-all")
    public String dbSelectTest() {
        log.info("select test");

        return String.format(
                "there are %d users with nickname=name ",
                dbService.findUsersByNickname("name").size());
    }
}
