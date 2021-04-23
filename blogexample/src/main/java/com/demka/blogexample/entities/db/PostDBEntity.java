package com.demka.blogexample.entities.db;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "posts")
public class PostDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserDBEntity authorPost;

    @OneToMany(mappedBy = "post")
    private List<CommentDBEntity> comments;

    @ManyToMany
    @JoinTable(
            name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<TagDBEntity> tags;

    private String text;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserDBEntity> likes;


}