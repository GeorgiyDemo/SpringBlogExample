package com.demka.blogexample.services;

import com.demka.blogexample.entities.CommentEntity;
import com.demka.blogexample.repos.CommentsRepo;
import com.demka.blogexample.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    private final CommentsRepo commentsRepo;

    @Autowired
    public CommentsService(CommentsRepo commentsRepo){
        this.commentsRepo = commentsRepo;
    }

    public void create(CommentEntity client){
        commentsRepo.save(client);
    }

    public void update(CommentEntity client){
        commentsRepo.save(client);
    }

    public void delete(CommentEntity client){
        commentsRepo.delete(client);
    }

    public List<CommentEntity> findAll(){
        return commentsRepo.findAll();
    }

    public Optional<CommentEntity> find(Long id){
        return commentsRepo.findById(id);
    }

}
