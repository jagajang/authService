package com.authserver.mainserver.auth.dto;

import lombok.Getter;

@Getter
public class UserRegisterForm extends UserInfoForm {
    private String nickname;

    public UserRegisterForm(
            String email,
            String password,
            String nickname) {
        super(email, password);
        this.nickname = nickname;
    }
}
