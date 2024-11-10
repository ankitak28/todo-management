package net.javaguides.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
