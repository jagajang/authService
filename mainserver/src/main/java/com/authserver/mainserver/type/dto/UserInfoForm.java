package com.authserver.mainserver.type.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoForm {
    private String email;
    private String password;
}
