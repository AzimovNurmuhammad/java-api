package com.NextSpring.NextSpring.Secret;


import com.NextSpring.NextSpring.entity.enummration.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JwtProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private String validityMilliSecound;

    public String createToken(String username, Set<Role> roles){

    }
}
