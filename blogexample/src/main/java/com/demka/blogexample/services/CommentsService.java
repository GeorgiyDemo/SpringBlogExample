package com.demka.blogexample.services;

import com.demka.blogexample.entities.db.CommentDBEntity;
import com.demka.blogexample.repos.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    private final CommentsRepo commentsRepo;

    @Autowired
    public CommentsService(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    public void create(CommentDBEntity client) {
        commentsRepo.save(client);
    }

    public void update(CommentDBEntity client) {
        commentsRepo.save(client);
    }

    public void delete(CommentDBEntity client) {
        commentsRepo.delete(client);
    }

    public List<CommentDBEntity> findAll() {
        return commentsRepo.findAll();
    }

    public Optional<CommentDBEntity> find(Long id) {
        return commentsRepo.findById(id);
    }

}
