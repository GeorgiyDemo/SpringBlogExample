package com.demka.blogexample.repos;

import com.demka.blogexample.entities.db.PostDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostsRepo extends JpaRepository<PostDBEntity, Long> {
    Optional<PostDBEntity> findBySlug(String slug);
}