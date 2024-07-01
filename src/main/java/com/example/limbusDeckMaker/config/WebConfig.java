package com.example.limbusDeckMaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Applies to all endpoints
                        .allowedOrigins("http://3.39.211.127:8080", "http://localhost:3000", "https://d11u3ddr72a0sb.cloudfront.net", "https://limbus.store", "http://limbus.store:8080", "http://localhost:8080", "https://baslimbus.info", "http://baslimbus.info", "https://d11u3ddr72a0sb.cloudfront.net.", "https://www.baslimbus.info")
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                        .allowedHeaders("*") // Allowed headers
                        .allowCredentials(true); // Credentials/cookies allowed
            }
        };
    }
}
