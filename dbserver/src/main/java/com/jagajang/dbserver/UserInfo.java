package com.jagajang.dbserver;

import lombok.Getter;

@Getter
public class UserInfo {
    private String email;
    private String password;

    UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
