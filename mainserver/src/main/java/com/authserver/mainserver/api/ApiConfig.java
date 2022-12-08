package com.authserver.mainserver.api;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class ApiConfig {
    @Bean
    public WebClient authWebClient() {
        String domain = "http://localhost:8081";

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClientBuilder()))
                .baseUrl(domain)
                .defaultCookie("key", "value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public WebClient dbWebClient() {
        String domain = "http://localhost:8082";

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClientBuilder()))
                .baseUrl(domain)
                .defaultCookie("key", "value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    //@Bean
    //@Scope("prototype")
    private HttpClient httpClientBuilder() {
        return HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
                .responseTimeout(Duration.ofMillis(2000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(2000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(2000, TimeUnit.MILLISECONDS))
                );
    }
}
