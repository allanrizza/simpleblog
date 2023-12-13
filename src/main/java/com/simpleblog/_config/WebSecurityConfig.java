package com.simpleblog._config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(
                authorizateConfig -> {
                    authorizateConfig.requestMatchers("/public").permitAll();
                    authorizateConfig.requestMatchers("/logout").permitAll();
                    authorizateConfig.anyRequest().authenticated();
                }
            )
            .formLogin(Customizer.withDefaults())
            .build();
    }

}
