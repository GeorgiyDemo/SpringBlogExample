package com.demka.blogexample.repos;

import com.demka.blogexample.entities.db.CommentDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<CommentDBEntity, Long> {
}