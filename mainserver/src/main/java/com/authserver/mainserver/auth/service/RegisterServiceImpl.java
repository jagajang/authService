package com.authserver.mainserver.auth.service;

import com.authserver.mainserver.api.db.DBRestTemplateService;
import com.authserver.mainserver.auth.dto.UserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private DBRestTemplateService dbRestTemplateService;

    @Override
    public void register(UserRegisterForm form) throws Exception {
        String domain = "http://localhost:8081";
        String path = "/";
    }
}
