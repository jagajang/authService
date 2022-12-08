package com.authserver.mainserver.api.auth;

import com.authserver.mainserver.type.dto.UserInfoForm;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
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
public class AuthWebClientServiceImpl implements AuthWebClientService {
    private final WebClient authWebClient;

    AuthWebClientServiceImpl() {
        String domain = "http://localhost:8081";

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
                .responseTimeout(Duration.ofMillis(2000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(2000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(2000, TimeUnit.MILLISECONDS))
                );

        authWebClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(domain)
                .defaultCookie("key", "value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

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
