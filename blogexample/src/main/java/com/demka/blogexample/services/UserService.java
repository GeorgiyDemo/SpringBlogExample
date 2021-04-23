package com.demka.blogexample.services;

import com.demka.blogexample.entities.db.UserDBEntity;
import com.demka.blogexample.entities.request.AuthRequestEntity;
import com.demka.blogexample.repos.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void create(UserDBEntity client) {
        userRepo.save(client);
    }

    public void update(UserDBEntity client) {
        userRepo.save(client);
    }

    public void delete(UserDBEntity client) {
        userRepo.delete(client);
    }

    public List<UserDBEntity> findAll() {
        return userRepo.findAll();
    }

    public Optional<UserDBEntity> find(Long id) {
        return userRepo.findById(id);
    }

    public String authUser(AuthRequestEntity authRequestEntity) {
        Optional<UserDBEntity> bufResult = userRepo.findByEmailAndPassword(authRequestEntity.getEmail(), authRequestEntity.getPassword());
        if (bufResult.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String jsonString = objectMapper.writeValueAsString(bufResult.get());
                return jsonString;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

}
