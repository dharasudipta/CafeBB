package com.haveitfast.cafe.bbuserservice.adapter.in.web.basic.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //ToDo environment specific CORS config needed
        //ToDo Enable BasicAuth or Configure Token based auth
        return http
//                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
                .csrf().disable()
                .cors().and()
                .headers(headerConfigurer -> headerConfigurer.frameOptions().sameOrigin())//for H2-Console issue
                .build();
    }
}
