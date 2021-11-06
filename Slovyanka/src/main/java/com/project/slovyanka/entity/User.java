package com.project.slovyanka.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    /**
     * Для покращення зручності сайту, щоб користувачам не запам'ятовувати і email, і username.
     * Колонка email буде також username для користувача, оскільки бібліотека налаштована на username, а email у нас
     * має унікальне значення, то пошту будемо використовувати, як і username, а самостійної колонки username у нас не буде
     */
    @Column(name = "emailUsername", nullable = false)
    private String emailUsername;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(role);
    }

    /**
     * Наш email є також username.
     * @return email користувача
     */
    @Override
    public String getUsername() {
        return getEmailUsername();
    }
}
