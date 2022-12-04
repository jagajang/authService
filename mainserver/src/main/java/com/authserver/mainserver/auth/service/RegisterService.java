package com.authserver.mainserver.auth.service;

import com.authserver.mainserver.auth.dto.UserRegisterForm;

public interface RegisterService {
    void register(UserRegisterForm form) throws Exception;
}
