package com.demka.blogexample.repos;

import com.demka.blogexample.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<PostEntity, Long> {
}