/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.gatewayserver.config;

import com.eazybytes.gatewayserver.service.client.CustomerSummaryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author mark.hungtruong
 * @version ClientConfig.java, v 0.1 2026年02月13日 5:13 PM mark.hungtruong
 */
@Configuration
public class ClientConfig {

    @Value("${app.base-url}")
    private String baseUrl;

    @Bean
    public CustomerSummaryClient customerSummaryClient() {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(CustomerSummaryClient.class);
    }
}