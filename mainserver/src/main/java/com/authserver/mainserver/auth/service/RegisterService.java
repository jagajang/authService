package com.authserver.mainserver.auth.service;

import com.authserver.mainserver.type.dto.UserInfoNameForm;

public interface RegisterService {
    void register(UserInfoNameForm form) throws Exception;
}
