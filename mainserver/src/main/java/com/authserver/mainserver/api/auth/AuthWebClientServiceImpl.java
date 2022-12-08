package com.authserver.mainserver.api.auth;

import com.authserver.mainserver.type.dto.UserInfoForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@Slf4j
public class AuthWebClientServiceImpl implements AuthWebClientService {
    @Qualifier("authWebClient")
    private WebClient authWebClient;

    @Override
    public String login(UserInfoForm form) {
        final String uri = "/login";

        return authWebClient.post()
                .uri(uri)
                .body(BodyInserters
                        .fromFormData("email", form.getEmail())
                        .with("password", form.getPassword()))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
