package com.NextSpring.NextSpring.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(@Lazy UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

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
                .antMatchers("/api/post/paging/**").hasRole("ADMIN")
                .antMatchers("/api/post").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/posts").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/authenticate").permitAll()
//.antMatchers("/api/authenticate").permitAll() bu yondi shu buruq bilan.
//      prmitAll() buyrug'i bilan autarizatsiyani uchirib quysa buladi
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}
