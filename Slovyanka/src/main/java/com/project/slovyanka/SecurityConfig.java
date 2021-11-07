package com.project.slovyanka;

import com.project.slovyanka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Illia Koshkin
 * Цей клас налаштовує безпеку(Spring Security)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    /**
     * Це конфігураційний метод.
     * @param http об'єкт HttpSecurity, що нолаштовує безпеку
     * @throws Exception кидається помилка, у разі помилки налаштувань
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/change-language", "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll();
    }

    /**
     * Цей ще одне перевизначення методу configure(), яке виконує вхід в аккаунт.
     * @param auth ціль для передачі сервісу користувачів(UserService)
     * @throws Exception будь-яка помилка може бути
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    /**
     * Цей метод також налаштовує AuthenticationManagerBuilder
     * @param builder ціль для передачі сервісу користувачів(UserService)
     * @throws Exception будь-яка помилка може бути
     */
    @Autowired
    public void globalConfig(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userService);
    }

    /**
     * Цей метод кодує пароль(для безпеки)
     * @return об'єкт PasswordEncoder(доступ через GOF-паттерн Singleton(одиночка))
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
