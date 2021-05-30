package com.demka.blogexample.entities.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class UserDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String login;

    @JsonIgnore
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;
    private boolean isActive;

    @JsonBackReference(value = "authorPost")
    @OneToMany(mappedBy = "authorPost")
    private Set<PostDBEntity> posts;

    @JsonBackReference(value = "authorComment")
    @OneToMany(mappedBy = "authorComment")
    private Set<CommentDBEntity> comments;

    @JsonBackReference(value = "likes")
    @ManyToMany(mappedBy = "likes")
    private Set<PostDBEntity> likes;
}