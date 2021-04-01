package com.demka.blogexample.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    private String password;
    private boolean isActive;

    @OneToMany(mappedBy = "authorPost")
    private Set<PostEntity> posts;

    @OneToMany(mappedBy = "authorComment")
    private Set<CommentEntity> comments;

    @ManyToMany(mappedBy = "likes")
    private Set<PostEntity> likes;
}