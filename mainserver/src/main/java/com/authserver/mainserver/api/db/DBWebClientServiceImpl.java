package com.authserver.mainserver.api.db;

import com.authserver.mainserver.auth.dto.UserRegisterForm;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DBWebClientServiceImpl implements DBWebClientService {
    private final String domain = "localhost:8081";

    @Override
    public boolean registerUser(UserRegisterForm form) {
        String uri = domain + "/register";

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(uri, form, );
        restTemplate.postForEntity(uri, form, String.class);


        return false;
    }
}
