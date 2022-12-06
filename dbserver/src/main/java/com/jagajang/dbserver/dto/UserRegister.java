package com.jagajang.dbserver.dto;

import lombok.Getter;

@Getter
public class UserRegister extends UserInfo {
    private String nickname;

    public UserRegister(
            String email,
            String password,
            String nickname) {
        super(email, password);
        this.nickname = nickname;
    }
}
