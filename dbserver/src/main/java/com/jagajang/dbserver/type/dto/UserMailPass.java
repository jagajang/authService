package com.jagajang.dbserver.type.dto;

import lombok.Getter;

@Getter
public class UserMailPass {
    private final String email;
    private final String password;

    UserMailPass(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
