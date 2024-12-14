package com.jwt.example.models;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Users {

    private String userId;
    private String name;
    private String email;

    public Users(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
