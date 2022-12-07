package com.jagajang.dbserver.type.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequestInfo {
    private String email;
    private String password;
    private String nickname;
}
