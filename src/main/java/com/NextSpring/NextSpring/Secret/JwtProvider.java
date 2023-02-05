package com.NextSpring.NextSpring.Secret;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private String validityMilliSecound;

    @PostConstruct
    protected void init(){
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String username, Authentication authentication){
        String roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityMilliSecound);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
//  parollardi encode qilish uchun ishlatiladi
        return new BCryptPasswordEncoder();
    }
}
