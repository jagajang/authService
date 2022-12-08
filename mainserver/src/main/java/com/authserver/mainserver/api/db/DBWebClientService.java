package com.authserver.mainserver.api.db;

import com.authserver.mainserver.type.dto.UserInfoNameForm;
import com.authserver.mainserver.type.dto.UserMailName;

import java.util.List;

public interface DBWebClientService {
    String apiTest();
    Boolean registerUser(UserInfoNameForm form);

    List<UserMailName> searchUserWithEmail(String email);
    List<UserMailName> searchUserWithNickname(String nickname);
}
