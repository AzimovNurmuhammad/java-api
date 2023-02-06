package com.NextSpring.NextSpring.Resourse;

import com.NextSpring.NextSpring.Resourse.VueModem.LoginVM;
import com.NextSpring.NextSpring.Secret.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserJWTResourse {
    private final JwtProvider jwtProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public UserJWTResourse(JwtProvider jwtProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.jwtProvider = jwtProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
//    @Valid bundan yozishdan maqsad login yokipassword null mi yoki null emasmiga tekshiradi.
    public ResponseEntity authore(@Valid @RequestBody LoginVM loginVM){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getLogin(), loginVM.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        /*

         tepadagi ikkalsini maqsadi foydalanuvchi ma'lumotlar bazasida bor yoki yo'qligini tekshiradi

        */

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.createToken(loginVM.getLogin(), authentication);

        return ResponseEntity.ok(jwt);



    }
}
