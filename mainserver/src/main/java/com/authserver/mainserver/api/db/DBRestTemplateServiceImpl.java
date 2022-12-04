package com.authserver.mainserver.api.db;

import com.authserver.mainserver.auth.dto.UserRegisterForm;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DBRestTemplateServiceImpl implements DBRestTemplateService {
    private final String domain = "localhost:8081";

    @Override
    public boolean registerUser(UserRegisterForm form) {
        RestTemplate restTemplate = new RestTemplate();


        return false;
    }
}
