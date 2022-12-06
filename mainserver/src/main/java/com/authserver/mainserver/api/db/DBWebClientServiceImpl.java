package com.authserver.mainserver.api.db;

import com.authserver.mainserver.auth.dto.UserRegisterForm;
import org.springframework.stereotype.Service;

@Service
public class DBWebClientServiceImpl implements DBWebClientService {
    private final String domain = "localhost:8081";

    @Override
    public boolean registerUser(UserRegisterForm form) {
        String uri = domain + "/adduser";

        return false;
    }
}
