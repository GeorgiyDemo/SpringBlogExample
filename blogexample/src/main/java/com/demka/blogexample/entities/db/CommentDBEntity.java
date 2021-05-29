package com.demka.blogexample.entities.db;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "comments")
public class CommentDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserDBEntity authorComment;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostDBEntity post;

    private String text;
}
