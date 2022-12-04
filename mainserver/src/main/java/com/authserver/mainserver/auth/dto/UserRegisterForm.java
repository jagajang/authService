package com.authserver.mainserver.auth.dto;

import com.authserver.mainserver.type.UserRole;
import lombok.Getter;

@Getter
public class UserRegisterForm extends UserInfoForm {
    private UserRole role;
    private String nickname;

    public UserRegisterForm(
            String email,
            String password,
            UserRole role,
            String nickname) {
        super(email, password);
        this.role = role;
        this.nickname = nickname;
    }
}
