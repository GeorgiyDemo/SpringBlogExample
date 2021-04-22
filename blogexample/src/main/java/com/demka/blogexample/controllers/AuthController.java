package com.demka.blogexample.controllers;

import com.demka.blogexample.entities.AuthEntity;
import com.demka.blogexample.entities.UserEntity;
import com.demka.blogexample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Авторизация пользователя
     * @param authEntity - сущность для авторизации
     * @return
     */
    @PostMapping("/auth")
    public ResponseEntity<?> authUser(@RequestBody AuthEntity authEntity) {
        if (userService.authUser(authEntity)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Регистрация пользователя в системе
     * @param user - сущность пользователя
     * @return
     */
    @PostMapping("/registration")
    public ResponseEntity<?> regUser(@RequestBody UserEntity user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
