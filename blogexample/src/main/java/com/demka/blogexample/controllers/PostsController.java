package com.demka.blogexample.controllers;

import com.demka.blogexample.entities.db.PostDBEntity;
import com.demka.blogexample.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService itemService;

    @Autowired
    public PostsController(PostsService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    public ResponseEntity<?> createItem(@RequestBody PostDBEntity item) {
        itemService.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAllItems() {
        List<PostDBEntity> itemList = itemService.findAll();
        if (itemList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        Optional<PostDBEntity> currentItem = itemService.find(id);
        if (currentItem.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentItem.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(name = "id") Long id, @RequestBody PostDBEntity newItem) {
        Optional<PostDBEntity> currentItemOptional = itemService.find(id);
        if (currentItemOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PostDBEntity currentItem = currentItemOptional.get();
        currentItem.setSlug(newItem.getSlug());
        currentItem.setAuthorPost(newItem.getAuthorPost());
        currentItem.setComments(newItem.getComments());
        currentItem.setTags(newItem.getTags());
        currentItem.setText(newItem.getText());
        currentItem.setTitle(newItem.getTitle());
        currentItem.setLikes(newItem.getLikes());

        itemService.update(currentItem);
        return new ResponseEntity<>(currentItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(name = "id") Long id) {
        Optional<PostDBEntity> currentItemOptional = itemService.find(id);
        if (currentItemOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        itemService.delete(currentItemOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
