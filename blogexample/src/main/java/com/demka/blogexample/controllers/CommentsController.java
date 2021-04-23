package com.demka.blogexample.controllers;

import com.demka.blogexample.entities.db.CommentDBEntity;
import com.demka.blogexample.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentsController {

    private final CommentsService itemService;

    @Autowired
    public CommentsController(CommentsService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    public ResponseEntity<?> createItem(@RequestBody CommentDBEntity item) {
        itemService.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAllItems() {
        List<CommentDBEntity> itemList = itemService.findAll();
        if (itemList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        Optional<CommentDBEntity> currentItem = itemService.find(id);
        if (currentItem.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentItem.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(name = "id") Long id, @RequestBody CommentDBEntity newItem) {
        Optional<CommentDBEntity> currentItemOptional = itemService.find(id);
        if (currentItemOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CommentDBEntity currentItem = currentItemOptional.get();

        currentItem.setAuthorComment(newItem.getAuthorComment());
        currentItem.setPost(newItem.getPost());
        currentItem.setText(newItem.getText());

        itemService.update(currentItem);
        return new ResponseEntity<>(currentItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(name = "id") Long id) {
        Optional<CommentDBEntity> currentItemOptional = itemService.find(id);
        if (currentItemOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        itemService.delete(currentItemOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
