package com.demka.blogexample.repos;

import com.demka.blogexample.entities.db.TagDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepo extends JpaRepository<TagDBEntity, Long> {
}