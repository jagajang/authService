package com.jagajang.dbserver.type.dto;

import lombok.Getter;

@Getter
public class UserMailPass {
    private String email;
    private String password;

    UserMailPass(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
