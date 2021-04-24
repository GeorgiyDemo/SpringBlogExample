package com.demka.blogexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}1234").roles("AUTHUSER", "NOAUTHUSER")
                .and()
                .withUser("admin").password("{noop}12345").roles("AUTHUSER", "ADMIN", "NOAUTHUSER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //неавторизаованные пользователи: два поста (регистрация/авторизация) + геты
        //авторизованные пользователи: все остальное
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/tags").permitAll()
                .antMatchers(HttpMethod.POST, "/registration").permitAll()
                .anyRequest().hasRole("AUTHUSER")
                .and()
                .csrf().disable()
                .formLogin().disable();
        http.cors();
    }
}
