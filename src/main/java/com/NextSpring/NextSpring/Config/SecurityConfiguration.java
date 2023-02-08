package com.NextSpring.NextSpring.Config;
import com.NextSpring.NextSpring.Secret.JwtProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final JwtProvider jwtProvider;

    public SecurityConfiguration(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/api/post/paging/**").hasRole("USER")
                .antMatchers("/api/post").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/posts").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/authenticate").permitAll()
//.antMatchers("/api/authenticate").permitAll() bu yondi shu buruq bilan.
//      prmitAll() buyrug'i bilan autarizatsiyani uchirib quysa buladi
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .apply(securityConfigurerAdapter());
    }

    private JWTConfigure securityConfigurerAdapter(){
        return new JWTConfigure(jwtProvider);
    }

}
