package com.authserver.mainserver.api.db;

import com.authserver.mainserver.type.dto.UserInfoNameForm;

public interface DBWebClientService {
    Boolean registerUser(UserInfoNameForm form);
}
