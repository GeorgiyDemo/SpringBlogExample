package com.demka.blogexample.services;

import com.demka.blogexample.entities.db.PostDBEntity;
import com.demka.blogexample.repos.PostsRepo;
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

    public void create(PostDBEntity client) {
        postsRepo.save(client);
    }

    public void update(PostDBEntity client) {
        postsRepo.save(client);
    }

    public void delete(PostDBEntity client) {
        postsRepo.delete(client);
    }

    public Optional<PostDBEntity> findBySlug(String slug) {
        return postsRepo.findBySlug(slug);
    }

    public List<PostDBEntity> findAll() {
        return postsRepo.findAll();
    }

    public Optional<PostDBEntity> find(Long id) {
        return postsRepo.findById(id);
    }
}
