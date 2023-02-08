package com.NextSpring.NextSpring.Config;

import com.NextSpring.NextSpring.Secret.JWTFilter;
import com.NextSpring.NextSpring.Secret.JwtProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtProvider jwtProvider;

    public JWTConfigure(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JWTFilter jwtFilter = new JWTFilter(jwtProvider);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
