package com.demka.blogexample.entities.request;

import lombok.Data;

@Data
public class AuthRequestEntity {
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
