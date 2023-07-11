package com.dilli.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 

@Configuration
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/employees")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("*");

        registry.addMapping("/employees")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("*");
        
        registry.addMapping("/employees/{id}")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("*");
    }
}