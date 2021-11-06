package com.project.slovyanka;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Illia Koshkin
 * Цей клас налаштовує безпеку(Spring Security)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Це конфігураційний метод.
     * @param http об'єкт HttpSecurity, що нолаштовує безпеку
     * @throws Exception кидається помилка, у разі помилки налаштувань
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/change-language").permitAll();
    }
}
