package com.authserver.mainserver.type.dto;

import lombok.Getter;

@Getter
public class UserInfoForm {
    private String email;
    private String password;

    public UserInfoForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}