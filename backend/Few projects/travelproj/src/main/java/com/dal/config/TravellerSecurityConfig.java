package com.dal.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
public class TravellerSecurityConfig {
	
	
	@Autowired
	TravellerAuthProvider travellerAuthProvider;
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http.authorizeHttpRequests().requestMatchers("/welcome/**").permitAll()
		.requestMatchers("/login/**").permitAll()
				.requestMatchers("/listtour/**").permitAll()
				.requestMatchers("/v2/api-docs",
						"/v3/api-docs/**",
						"/swagger-resources/configuration/ui",  
						"/swagger-resources/configuration/security", 
						"/webjars/**",
						"/swagger-ui.html","/swagger-ui/**").permitAll();
				/*
				 *  Line 44 is very important
				 *  http://localhost:8183/swagger-ui/index.html
				 */	
 
    	 http.authorizeHttpRequests().requestMatchers("/welcome/**").authenticated()
         .requestMatchers("/listtour/**").permitAll()
         .requestMatchers("/requestlocaltour/**").authenticated()
         .requestMatchers("/requestforeigntour/**").authenticated()
         .requestMatchers("/addtraveller/**","/listalltraveller").authenticated()    
         .requestMatchers("/login").permitAll()
         .requestMatchers("/actuator/**").permitAll();
  
         
         http.httpBasic();
         http.csrf().disable();
         return http.build();
         
    }
    
    @Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(travellerAuthProvider);
		return authenticationManagerBuilder.build();
	}
    
    
    @Bean
    public org.springframework.web.filter.CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); // this allows all origin
        config.addAllowedHeader("*"); // this allows all headers
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.setExposedHeaders(Arrays.asList("Authorization"));
        config.setMaxAge((long) 3600000);
        source.registerCorsConfiguration("/**", config);
        return new org.springframework.web.filter.CorsFilter(source);
    }
       
 
}