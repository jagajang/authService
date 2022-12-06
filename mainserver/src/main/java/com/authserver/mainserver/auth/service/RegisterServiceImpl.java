package com.authserver.mainserver.auth.service;

import com.authserver.mainserver.api.db.DBWebClientService;
import com.authserver.mainserver.auth.dto.UserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private DBWebClientService dbWebClientService;

    @Override
    public void register(UserRegisterForm form) throws Exception {
        dbWebClientService.registerUser(form);
    }
}
