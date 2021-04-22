package com.demka.blogexample.entities;

import lombok.Data;

@Data
public class AuthEntity {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "AuthEntity{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
