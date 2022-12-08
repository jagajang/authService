package com.authserver.mainserver.api.db;

import com.authserver.mainserver.type.dto.UserInfoNameForm;

public interface DBWebClientService {
    String apiTest();
    Boolean registerUser(UserInfoNameForm form);
}
