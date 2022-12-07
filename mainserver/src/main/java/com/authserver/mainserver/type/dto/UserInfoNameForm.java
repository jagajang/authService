package com.authserver.mainserver.type.dto;

import lombok.Getter;

@Getter
public class UserInfoNameForm extends UserInfoForm {
    private String nickname;

    public UserInfoNameForm(
            String email,
            String password,
            String nickname) {
        super(email, password);
        this.nickname = nickname;
    }
}
