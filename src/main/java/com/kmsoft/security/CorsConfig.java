package com.kmsoft.security;

// src/main/java/com/yourpackage/config/CorsConfig.java (adjust package as needed)

// Use your actual package name

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow requests from your Angular frontend domain
                registry.addMapping("/**") // Apply CORS to all endpoints
                        .allowedOrigins("https://invsoft-client.onrender.com","http://localhost:4200") // <--- IMPORTANT: Replace with your actual Angular frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS","PATCH") // Allow common HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow sending cookies/auth headers
            }
        };
    }
}