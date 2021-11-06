package com.project.slovyanka.dto;

import lombok.*;

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
