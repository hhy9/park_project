package com.hhy.web;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://127.0.0.1:8080")
                .allowedOrigins("http://127.0.0.1:3000")
                .allowedOrigins("http://localhost:8080");
    }
}