package com.jagajang.dbserver.dto;

import lombok.Getter;

@Getter
public class UserInfoName extends UserInfo {
    private String nickname;

    public UserInfoName(
            String email,
            String password,
            String nickname) {
        super(email, password);
        this.nickname = nickname;
    }
}
