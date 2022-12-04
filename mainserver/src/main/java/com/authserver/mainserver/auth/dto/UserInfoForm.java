package com.authserver.mainserver.auth.dto;

import lombok.Getter;

@Getter
public class UserInfoForm {
    private String username;
    private String password;

    public UserInfoForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
