package com.project.slovyanka;

import com.project.slovyanka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RequestParam;

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
                .antMatchers("/", "/home", "/change-language").permitAll()
                .and()
                .formLogin().loginPage("/logIn").permitAll();
    }

    @Autowired
    private UserService userService;

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder builder) throws Exception {
//        UserDetails user =
//                User.builder()
//                        .username(email)
//                        .password(password)
//                        .roles(userService.loadUserByUsername(email).)
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
        builder.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
