package com.haveitfast.cafe.bbuserservice.adapter.in.web.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf().disable()
                .headers(headerConfigurer -> headerConfigurer.frameOptions().sameOrigin())//for H2-Console issue
                .build();
    }
}
