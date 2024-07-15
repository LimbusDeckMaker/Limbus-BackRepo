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
                        .allowedOrigins("http://3.39.211.127:8080", "http://localhost:3000", "https://limbus.store", "http://limbus.store:8080", "http://localhost:8080", "https://baslimbus.info", "http://baslimbus.info", "https://courageous-torte-9573b1.netlify.app", "https://www.baslimbus.info")
                        // .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                        .allowedHeaders("*"); // Allowed headers
                        //.allowCredentials(true); // Credentials/cookies allowed
            }
        };
    }
}
