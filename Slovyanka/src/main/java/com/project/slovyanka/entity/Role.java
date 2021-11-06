package com.project.slovyanka.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Illia Koshkin
 * Цей енам(перерахування) має усі допустимі ролі у цьому веб-застосунку
 */
public enum Role implements GrantedAuthority {
    GUEST, USER, ADMIN;

    /**
     * Це перевизначення(override) методу getAuthority() у GrantedAuthority
     * @return назву ролі переведену до строки(String)
     */
    @Override
    public String getAuthority() {
        return name();
    }
}
