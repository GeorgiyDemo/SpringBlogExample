package com.demka.blogexample.controllers;

import com.demka.blogexample.entities.db.UserDBEntity;
import com.demka.blogexample.entities.request.AuthRequestEntity;
import com.demka.blogexample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Авторизация пользователя
     *
     * @param authRequestEntity - сущность для авторизации
     * @return
     */
    @PostMapping("/auth")
    public ResponseEntity<?> authUser(@RequestBody AuthRequestEntity authRequestEntity) {

        String result = userService.authUser(authRequestEntity);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * TODO: Регистрация пользователя в системе
     *
     * @param user - сущность пользователя
     * @return
     */
    @PostMapping("/registration")
    public ResponseEntity<?> regUser(@RequestBody UserDBEntity user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
