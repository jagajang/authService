package com.jagajang.dbserver.type.dto;

import lombok.Getter;

@Getter
public class UserMailPassName extends UserMailPass {
    private final String nickname;

    public UserMailPassName(
            String email,
            String password,
            String nickname) {
        super(email, password);
        this.nickname = nickname;
    }
}
