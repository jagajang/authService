package com.authserver.mainserver.register.service;

import com.authserver.mainserver.api.db.DBWebClientService;
import com.authserver.mainserver.type.dto.UserInfoNameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private DBWebClientService dbWebClientService;

    @Override
    public void register(UserInfoNameForm form) throws Exception {
        dbWebClientService.registerUser(form);
    }
}
