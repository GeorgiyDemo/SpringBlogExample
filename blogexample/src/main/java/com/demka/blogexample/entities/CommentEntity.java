package com.demka.blogexample.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private UserEntity authorComment;

    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private PostEntity post;

    private String text;
}
