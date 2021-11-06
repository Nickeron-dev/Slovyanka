package com.project.slovyanka.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    GUEST, USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
