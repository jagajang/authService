package com.authserver.mainserver.api.db;

import com.authserver.mainserver.type.dto.UserInfoNameForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

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

        log.info(form.getEmail());

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
}
