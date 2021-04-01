package com.demka.blogexample.repos;

import com.demka.blogexample.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<CommentEntity, Long> {
}