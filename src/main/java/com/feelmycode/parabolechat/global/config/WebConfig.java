package com.feelmycode.parabolechat.global.config;

import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

public class WebConfig implements WebFluxConfigurer {
    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/chat/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "OPTIONS")
            .allowedHeaders("*")
            .exposedHeaders("*")
            .maxAge(MAX_AGE_SECS);
    }
}
