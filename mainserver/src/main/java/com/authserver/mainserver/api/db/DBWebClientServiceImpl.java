package com.authserver.mainserver.api.db;

import com.authserver.mainserver.type.dto.UserInfoNameForm;
import com.authserver.mainserver.type.dto.UserMailName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class DBWebClientServiceImpl implements DBWebClientService {
    @Qualifier("dbWebClient")
    private WebClient dbWebClient;

    @Override
    public String apiTest() {
        String uri = "/api-test";

        return dbWebClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public Boolean registerUser(UserInfoNameForm form) {
        String uri = "/register";

        return dbWebClient.post()
                .uri(uri)
                .body(BodyInserters
                        .fromFormData("email", form.getEmail())
                        .with("password", form.getPassword())
                        .with("nickname", form.getNickname()))
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    @Override
    public List<UserMailName> searchUserWithEmail(String email) {
        return null;
    }

    @Override
    public List<UserMailName> searchUserWithNickname(String nickname) {
        return null;
    }
}
