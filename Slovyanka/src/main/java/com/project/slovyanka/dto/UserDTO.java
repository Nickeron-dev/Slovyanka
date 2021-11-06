package com.project.slovyanka.dto;

import lombok.*;

/**
 * @author Illia Koshkin
 * Цей клас допомагає передавати в аргументах інших класів лише деякі з полів класа User.
 * Це дає можливість полегшити роботу з User класом та покращює ефективність застосунку.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
