package com.authserver.mainserver.register;

import lombok.Getter;

@Getter
public class RegisterForm {
    private String username;
    private String password;

    public RegisterForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
