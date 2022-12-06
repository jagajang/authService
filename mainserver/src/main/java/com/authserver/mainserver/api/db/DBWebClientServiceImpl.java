package com.authserver.mainserver.api.db;

import com.authserver.mainserver.auth.dto.UserRegisterForm;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class DBWebClientServiceImpl implements DBWebClientService {
    private final String domain = "http://localhost:8082";

    private WebClient webClient;

    DBWebClientServiceImpl() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
                .responseTimeout(Duration.ofMillis(2000))
                .doOnConnected(conn ->
                    conn.addHandlerLast(new ReadTimeoutHandler(2000, TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(2000, TimeUnit.MILLISECONDS))
                );

        webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(domain)
                .defaultCookie("key", "value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public String apiTest() {
        return webClient.get()
                .uri("/api-test")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public boolean registerUser(UserRegisterForm form) {
        String uri = "/adduser";

        webClient.post()
                .uri(uri)
                .body(Mono.just("Hello World"), String.class)
                .retrieve()
                .bodyToFlux(String.class);

        return false;
    }
}
