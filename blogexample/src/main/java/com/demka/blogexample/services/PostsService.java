package com.demka.blogexample.services;

import com.demka.blogexample.entities.PostEntity;
import com.demka.blogexample.repos.PostsRepo;
import com.demka.blogexample.repos.TagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    private final PostsRepo postsRepo;

    @Autowired
    public PostsService(PostsRepo postsRepo) {
        this.postsRepo = postsRepo;
    }

    public void create(PostEntity client) {
        postsRepo.save(client);
    }

    public void update(PostEntity client) {
        postsRepo.save(client);
    }

    public void delete(PostEntity client) {
        postsRepo.delete(client);
    }

    public List<PostEntity> findAll() {
        return postsRepo.findAll();
    }

    public Optional<PostEntity> find(Long id) {
        return postsRepo.findById(id);
    }
}
