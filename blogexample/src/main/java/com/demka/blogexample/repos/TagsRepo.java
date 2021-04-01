package com.demka.blogexample.repos;

import com.demka.blogexample.entities.PostEntity;
import com.demka.blogexample.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepo extends JpaRepository<TagEntity, Long> {
}