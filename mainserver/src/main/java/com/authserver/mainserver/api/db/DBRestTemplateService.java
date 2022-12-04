package com.authserver.mainserver.api.db;

import com.authserver.mainserver.auth.dto.UserRegisterForm;

public interface DBRestTemplateService {
    boolean registerUser(UserRegisterForm form);
}
