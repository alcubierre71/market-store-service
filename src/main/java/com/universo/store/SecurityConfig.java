package com.universo.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable() // disable CSRF for REST APIs
//            .authorizeHttpRequests(authz -> authz
//                .requestMatchers("/api/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // allow these without login
//                .anyRequest().authenticated() // everything else requires login
//            )
//            .httpBasic(); // enable basic auth for protected endpoints
//        return http.build();
//    }
    
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests( 
            //auth -> auth.requestMatchers("/encrypt").permitAll()  // Allow access to /encrypt
            auth -> auth.requestMatchers("/api/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // allow these without login
            .anyRequest().permitAll()   // Allows all requests without authentication
        ).csrf(csrf -> csrf.disable());   // Disable CSRF protection

        return http.build();

    }
    
}
