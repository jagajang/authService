package com.authserver.mainserver.api.auth;

import com.authserver.mainserver.type.dto.UserInfoForm;

public interface AuthWebClientService {
    String login(UserInfoForm form);
}
