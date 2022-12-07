package com.jagajang.dbserver.type.dto;

import com.jagajang.dbserver.dao.entity.UserEntity;
import com.jagajang.dbserver.type.enums.UserRole;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class UserResponseInfo {
    private String email;
    private String password;
    private String nickname;
    private UserRole role;
    private Date lastLogin;
}
