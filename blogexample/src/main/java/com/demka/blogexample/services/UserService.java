package com.demka.blogexample.services;

import com.demka.blogexample.entities.UserEntity;
import com.demka.blogexample.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void create(UserEntity client){
        userRepo.save(client);
    }

    public void update(UserEntity client){
        userRepo.save(client);
    }

    public void delete(UserEntity client){
        userRepo.delete(client);
    }

    public List<UserEntity> findAll(){
        return userRepo.findAll();
    }

    public Optional<UserEntity> find(Long id){
        return userRepo.findById(id);
    }

}
