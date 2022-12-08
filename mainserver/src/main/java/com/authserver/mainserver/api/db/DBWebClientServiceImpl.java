package com.authserver.mainserver.api.db;

import com.authserver.mainserver.type.dto.UserInfoNameForm;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
