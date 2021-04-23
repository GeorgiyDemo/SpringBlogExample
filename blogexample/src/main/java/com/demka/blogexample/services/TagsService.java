package com.demka.blogexample.services;

import com.demka.blogexample.entities.db.TagDBEntity;
import com.demka.blogexample.repos.TagsRepo;
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

    public void create(TagDBEntity client) {
        tagsRepo.save(client);
    }

    public void update(TagDBEntity client) {
        tagsRepo.save(client);
    }

    public void delete(TagDBEntity client) {
        tagsRepo.delete(client);
    }

    public List<TagDBEntity> findAll() {
        return tagsRepo.findAll();
    }

    public Optional<TagDBEntity> find(Long id) {
        return tagsRepo.findById(id);
    }
}
