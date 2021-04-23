package com.demka.blogexample.repos;

import com.demka.blogexample.entities.db.UserDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDBEntity, Long> {

    Optional<UserDBEntity> findByEmailAndPassword(String email, String password);
}