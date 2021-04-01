package com.demka.blogexample.services;

import com.demka.blogexample.entities.TagEntity;
import com.demka.blogexample.repos.TagsRepo;
import com.demka.blogexample.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsService {

    private final TagsRepo tagsRepo;

    @Autowired
    public TagsService(TagsRepo tagsRepo) {
        this.tagsRepo = tagsRepo;
    }

    public void create(TagEntity client) {
        tagsRepo.save(client);
    }

    public void update(TagEntity client) {
        tagsRepo.save(client);
    }

    public void delete(TagEntity client) {
        tagsRepo.delete(client);
    }

    public List<TagEntity> findAll() {
        return tagsRepo.findAll();
    }

    public Optional<TagEntity> find(Long id) {
        return tagsRepo.findById(id);
    }
}
